package org.example.dernekwebsitesi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    /**
     * Gelen MultipartFile dosyasını kaydeder ve kaydedilen dosya yolunu döner.
     * @param file yüklenen dosya
     * @return dosyanın uygulama kökünden göreli yolu
     * @throws IOException I/O hatası oluşursa
     */
    String store(MultipartFile file) throws IOException;

    /**
     * Daha önce kaydedilmiş dosyayı siler.
     * @param filePath store() tarafından dönülen göreli yol
     * @throws IOException I/O hatası oluşursa
     */
    void delete(String filePath) throws IOException;
}
