package org.example.dernekwebsitesi.controller;

import jakarta.validation.Valid;
import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface AdminDuyuruController {
    public DuyuruResponseDto kaydetDuyuru( DuyuruRequestDto dto) throws IOException;

    public void  silDuyuruById(Long ID);

    public DuyuruResponseDto güncelleDuyuru(Long ID ,DuyuruRequestDto dto) throws IOException;
}
