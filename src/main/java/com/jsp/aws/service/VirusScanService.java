package com.jsp.aws.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

@Service
public class VirusScanService {

    public boolean scan(InputStream inputStream) {
        try (Socket socket = new Socket("localhost", 3310);
             OutputStream out = socket.getOutputStream()) {

            out.write("zINSTREAM\0".getBytes());
            byte[] buffer = new byte[4096];
            int read;

            while ((read = inputStream.read(buffer)) >= 0) {
                byte[] size = ByteBuffer.allocate(4).putInt(read).array();
                out.write(size);
                out.write(buffer, 0, read);
            }
            out.write(new byte[]{0, 0, 0, 0});

            byte[] response = socket.getInputStream().readAllBytes();
            String result = new String(response);
            System.out.println("ClamAV Response → " + result);  // Debug output

            return !result.contains("FOUND");  // true = clean, false = infected
        } catch (Exception e) {
            throw new RuntimeException("Virus scanning failed → " + e.getMessage(), e);
        }
    }
}
