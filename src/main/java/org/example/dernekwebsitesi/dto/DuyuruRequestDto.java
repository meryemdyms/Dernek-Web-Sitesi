package org.example.dernekwebsitesi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuyuruRequestDto {

    private String konu;

    private String icerik;


    private LocalDate gecerlilikTarihi;

    private MultipartFile resim;
}
