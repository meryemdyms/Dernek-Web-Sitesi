package org.example.dernekwebsitesi.service;


import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HaberService {

    public HaberResponseDto kaydetHaber(HaberRequestDto haberDto);

    public void silHaber(Long ID);

    public HaberResponseDto guncelleHaber(Long ID,HaberRequestDto haberDto);

    public List<HaberResponseDto> listeleHaberler();

    public HaberResponseDto haberBilgi(Long ID);
}
