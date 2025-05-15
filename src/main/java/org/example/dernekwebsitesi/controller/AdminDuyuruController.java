package org.example.dernekwebsitesi.controller;

import jakarta.validation.Valid;
import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface AdminDuyuruController {
    public DuyuruResponseDto kaydetDuyuru( DuyuruRequestDto dto) ;

    public void  silDuyuru(Long ID);

    public DuyuruResponseDto guncelleDuyuru(Long ID ,DuyuruRequestDto dto) ;
}
