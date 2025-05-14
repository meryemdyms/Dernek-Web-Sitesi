package org.example.dernekwebsitesi.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuyuruRequestDto {

    @NotBlank(message = "Konu boş olamaz")
    private String konu;

    @NotBlank(message = "İçerik boş olamaz")
    private String icerik;

    @NotNull(message = "Geçerlilik tarihi girilmelidir")
    @FutureOrPresent(message = "Geçerlilik tarihi bugün veya gelecekte olmalı")
    private LocalDate gecerlilikTarihi;

    @NotNull(message = "Resim dosyası yüklenmelidir")
    private MultipartFile resim;
}
