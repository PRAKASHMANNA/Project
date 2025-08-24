package com.jsp.aws.controller;

	import com.jsp.aws.service.S3Service;
	import com.jsp.aws.service.VirusScanService;
	import com.jsp.aws.service.TextExtractionService;
	import lombok.AllArgsConstructor;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.web.multipart.MultipartFile;

	import java.io.*;
	import java.nio.file.*;

	@RestController
	@AllArgsConstructor
	public class S3Controller {

	    private final S3Service s3Service;
	    private final VirusScanService virusScanService;
	    private final TextExtractionService textExtractionService;

	    private final String tempDir = "C:/temp"; // Better to externalize later

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	        try {
	            // Restrict file types
	            String contentType = file.getContentType();
	            if (!(contentType.equals("application/pdf") || contentType.equals("text/plain"))) {
	                return ResponseEntity.badRequest().body("Unsupported file format");
	            }		
	            // Scan file for virus
	            if (!virusScanService.scan(file.getInputStream())) {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Virus detected. Upload rejected.");
	            }

	            // Save temporarily before upload
	            String fileName = file.getOriginalFilename();
	            Path filePath = Paths.get(tempDir, fileName);
	            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	            // Upload to S3
	            String uploadedKey = s3Service.uploadFile(file.getOriginalFilename(), filePath);
	            Files.deleteIfExists(filePath); // cleanup temp

	            return ResponseEntity.ok("✅ Uploaded successfully → S3 Key: " + uploadedKey);

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("❌ ERROR → " + e.getMessage());
	        }
	    }

	    @GetMapping("/extract")
	    public ResponseEntity<String> extractText(@RequestParam String keyName) {
	        try {
	        	if (!s3Service.doesFileExist(keyName)) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                        .body("❌ File not found in S3: " + keyName);
	            }
	            Path downloadPath = Paths.get(tempDir, keyName);
	            s3Service.downloadFileFromS3(keyName, downloadPath);

	            String content = textExtractionService.extractText(downloadPath, keyName);
	            return ResponseEntity.ok("Text extracted successfully. File saved at: " + downloadPath.toString() + "\n\n" + content);

	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("❌ ERROR → " + e.getMessage());
	        }
	    }
	}