package org.example.dernekwebsitesi.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HaberRequestDto {

    @NotBlank(message = "Konu boş olamaz")
    private String konu;

    @NotBlank(message = "İçerik boş olamaz")
    private String icerik;

    @NotNull(message = "Geçerlilik tarihi girilmelidir")
    @FutureOrPresent(message = "Geçerlilik tarihi bugün veya gelecekte olmalı")
    private LocalDate gecerlilikTarihi;

    @NotBlank(message = "Haber linki boş olamaz")
    private String haberLinki;
}
