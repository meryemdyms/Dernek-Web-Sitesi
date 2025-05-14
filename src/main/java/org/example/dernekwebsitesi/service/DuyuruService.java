package org.example.dernekwebsitesi.service;

import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public interface DuyuruService {
    public DuyuruResponseDto kaydetDuyuru(@RequestBody DuyuruRequestDto dto) throws IOException;

    public void  silDuyuruById(Long ID);

    public DuyuruResponseDto güncelleDuyuru(Long ID ,DuyuruRequestDto dto) throws IOException;

}
