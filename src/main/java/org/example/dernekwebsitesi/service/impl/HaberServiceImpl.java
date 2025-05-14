package org.example.dernekwebsitesi.service.impl;


import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.mapper.HaberMapper;
import org.example.dernekwebsitesi.repository.HaberRepository;
import org.example.dernekwebsitesi.service.HaberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HaberServiceImpl implements HaberService {

    @Autowired
    HaberRepository haberRepository;
    @Autowired
    HaberMapper haberMapper;


}
