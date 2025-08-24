package com.jsp.aws.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

@Service
public class TextExtractionService {

    public String extractText(Path path, String fileName) throws IOException {
        if (fileName.endsWith(".txt")) {
            return Files.readString(path);
        } else if (fileName.endsWith(".pdf")) {
            try (PDDocument document = PDDocument.load(path.toFile())) {
                PDFTextStripper stripper = new PDFTextStripper();
                return stripper.getText(document);
            }
        } else {
            throw new IllegalArgumentException("Unsupported file type → " + fileName);
        }
    }
}
