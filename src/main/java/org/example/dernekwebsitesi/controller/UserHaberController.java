package org.example.dernekwebsitesi.controller;

import org.example.dernekwebsitesi.dto.HaberResponseDto;

import java.util.List;

public interface UserHaberController {

    public List<HaberResponseDto> listeleHaberler();

    public HaberResponseDto haberBilgi(Long ID);
}
