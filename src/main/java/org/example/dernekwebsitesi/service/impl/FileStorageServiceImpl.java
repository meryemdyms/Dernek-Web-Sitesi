package org.example.dernekwebsitesi.service.impl;

import org.example.dernekwebsitesi.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path rootLocation;

    public FileStorageServiceImpl(@Value("${file.upload-dir}") String uploadDir) {
        // uploadDir örn. "src/main/resources/static" veya "src/main/resources/static/uploads/duyurular"
        this.rootLocation = Paths.get(uploadDir)
                .toAbsolutePath()
                .normalize();
        try {
            Files.createDirectories(this.rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory: " + this.rootLocation, e);
        }
    }

    @Override
    public String store(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) {
            throw new IOException("Invalid path sequence in filename: " + filename);
        }

        Path target = this.rootLocation.resolve(filename);
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);


        return "/" + filename;

    }

    @Override
    public void delete(String filePath) throws IOException {
        Path target = this.rootLocation.resolve(filePath).normalize();
        Files.deleteIfExists(target);
    }
}
