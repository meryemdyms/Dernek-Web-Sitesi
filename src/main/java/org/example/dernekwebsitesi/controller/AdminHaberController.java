package org.example.dernekwebsitesi.controller;

import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;

public interface AdminHaberController {

public HaberResponseDto kaydetHaber(HaberRequestDto haberDto);

public void silHaber(Long ID);

public HaberResponseDto guncelleHaber(Long ID,HaberRequestDto haberDto);
}
