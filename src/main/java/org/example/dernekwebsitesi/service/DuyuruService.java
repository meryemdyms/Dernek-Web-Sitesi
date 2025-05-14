package org.example.dernekwebsitesi.service;

import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface DuyuruService {
    public DuyuruResponseDto kaydetDuyuru(@RequestBody DuyuruRequestDto dto) throws IOException;

    public void  silDuyuru(Long ID);

    public DuyuruResponseDto guncelleDuyuru(Long ID ,DuyuruRequestDto dto) throws IOException;

    public List<DuyuruResponseDto> listeleDuyurular();

}
