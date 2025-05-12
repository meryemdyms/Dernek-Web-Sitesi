package org.example.dernekwebsitesi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HaberResponseDto {
    private Long id;

    private String konu;

    private String icerik;

    private LocalDate gecerlilikTarihi;

    private String haberLinki;
}
