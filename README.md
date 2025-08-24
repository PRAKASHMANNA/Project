# Secure Document Uploader

This project is a **Spring Boot application** that provides secure file
upload, virus scanning, AWS S3 storage, text extraction, and file
download functionality.

------------------------------------------------------------------------

## Features

-   Upload files (`.pdf` and `.txt`) securely to **AWS S3** after virus
    scanning.
-   Prevents uploading infected files.
-   Extracts text from **PDF** and **TXT** files stored in S3.
-   Downloads files from **S3** and saves them locally in a `temp`
    directory.
-   Simple and clean API endpoints.

------------------------------------------------------------------------

## Tech Stack

-   **Spring Boot**
-   **AWS SDK v2 (S3)**
-   **Apache PDFBox** (for PDF text extraction)
-   **ClamAV** (for virus scanning)
-   **Lombok** (for cleaner code)

------------------------------------------------------------------------

## API Endpoints

### 1. Upload File

``` http
POST /upload
```

-   Request: Multipart file (`.pdf`, `.txt`)
-   Process:
    -   Virus scan → if clean, upload to S3
    -   If infected → reject upload
-   Response:
    -   ✅ Success: File uploaded with S3 key
    -   ❌ Failure: Virus detected / invalid file type

### 2. Extract Text

``` http
GET /extract?keyName={fileName}
```

-   Downloads file from **S3** to `C:/temp`
-   Extracts text if `.pdf` or `.txt`
-   Response: Extracted text

## Setup Instructions

1.  Clone the repository

    ``` bash
    git clone -b secureDocUploader https://github.com/PRAKASHMANNA/Project.git
    ```

2.  Configure AWS credentials in `application.properties`:

    ``` properties
    aws.accessKey=your-access-key
    aws.secretKey=your-secret-key
    aws.region=your-region
    aws.s3BucketName=your-bucket-name
    ```

3.  Run the Spring Boot application:

    ``` bash
    mvn spring-boot:run
    ```

4.  Test APIs via **Postman** or **Swagger UI**.

------------------------------------------------------------------------

## Security Notes

-   Virus scan ensures **no infected files** reach S3.
-   Temporary files saved in `C:/temp` for text extraction and download.
-   Only `.pdf` and `.txt` allowed for upload.

------------------------------------------------------------------------

## 👨‍💻 Author

Developed by **Prakash Manna**
