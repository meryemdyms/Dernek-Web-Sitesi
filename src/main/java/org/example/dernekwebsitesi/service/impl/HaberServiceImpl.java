package org.example.dernekwebsitesi.service.impl;


import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.mapper.HaberMapper;
import org.example.dernekwebsitesi.model.Duyuru;
import org.example.dernekwebsitesi.model.Haber;
import org.example.dernekwebsitesi.repository.HaberRepository;
import org.example.dernekwebsitesi.service.HaberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HaberServiceImpl implements HaberService {

    @Autowired
    HaberRepository haberRepository;
    @Autowired
    HaberMapper haberMapper;


    @Override
    public HaberResponseDto kaydetHaber(HaberRequestDto haberDto) {

      Haber entity = haberMapper.dtoToEntity(haberDto);
      Haber saved = haberRepository.save(entity);

        return haberMapper.entityToDto(saved);
    }

    @Override
    public void silHaber(Long ID) {

        Optional<Haber> optional = haberRepository.findById(ID);
        if (optional.isPresent())
        {
            haberRepository.delete(optional.get());
        }

    }

    @Override
    public HaberResponseDto guncelleHaber(Long ID, HaberRequestDto haberDto) {

        Optional<Haber> optional = haberRepository.findById(ID);

        if (optional.isEmpty()){
            return null;
        }

        Haber dbHaber = optional.get();
        dbHaber.setKonu(haberDto.getKonu());
        dbHaber.setIcerik(haberDto.getIcerik());
        dbHaber.setHaberLinki(haberDto.getHaberLinki());


        Haber saved = haberRepository.save(dbHaber);
        return haberMapper.entityToDto(saved);
    }

    @Override
    public List<HaberResponseDto> listeleHaberler() {
        List<HaberResponseDto> haberDtoList = new ArrayList<>();
        List<Haber> haberList = haberRepository.findAll();

        for (Haber haber : haberList)
        {
            HaberResponseDto dto = haberMapper.entityToDto(haber);
            haberDtoList.add(dto);
        }

        return haberDtoList;
    }

    @Override
    public HaberResponseDto haberBilgi(Long ID) {
        return haberRepository.findById(ID)
                .map(haberMapper::entityToDto)
                .orElse(null);
    }
}
