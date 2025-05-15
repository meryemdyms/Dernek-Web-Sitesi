package org.example.dernekwebsitesi.service.impl;

import org.example.dernekwebsitesi.exception.BaseException;
import org.example.dernekwebsitesi.exception.ErrorMessage;
import org.example.dernekwebsitesi.exception.MessageType;
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
        this.rootLocation = Paths.get(uploadDir)
                .toAbsolutePath()
                .normalize();
        try {
            Files.createDirectories(this.rootLocation);
        } catch (IOException e) {
            throw new BaseException(
                    new ErrorMessage(
                            MessageType.FILE_STORAGE_ERROR,
                            "Dizin oluşturulamadı: " + this.rootLocation
                    )
            );
        }
    }

    @Override
    public String store(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains("..")) {
            throw new BaseException(
                    new ErrorMessage(
                            MessageType.FILE_STORAGE_ERROR,
                            "Geçersiz dosya adı: " + filename
                    )
            );
        }

        try {
            Path target = this.rootLocation.resolve(filename);
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (IOException e) {
            throw new BaseException(
                    new ErrorMessage(
                            MessageType.FILE_STORAGE_ERROR,
                            "Dosya kaydedilemedi: " + filename
                    )
            );
        }
    }

    @Override
    public void delete(String filePath) {
        try {
            Path target = this.rootLocation.resolve(filePath).normalize();
            Files.deleteIfExists(target);
        } catch (IOException e) {
            throw new BaseException(
                    new ErrorMessage(
                            MessageType.FILE_STORAGE_ERROR,
                            "Dosya silinemedi: " + filePath
                    )
            );
        }
    }
}
