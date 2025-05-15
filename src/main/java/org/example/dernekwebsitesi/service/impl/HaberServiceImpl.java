package org.example.dernekwebsitesi.service.impl;


import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.exception.BaseException;
import org.example.dernekwebsitesi.exception.ErrorMessage;
import org.example.dernekwebsitesi.exception.MessageType;
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

        new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND,"Haber id=" + ID));

    }

    @Override
    public HaberResponseDto guncelleHaber(Long ID, HaberRequestDto haberDto) {

        Optional<Haber> optional = haberRepository.findById(ID);

        if (optional.isEmpty()){
            new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND, "Haber id=" + ID));
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

        Optional<Haber> optional = haberRepository.findById(ID);

        if (optional.isPresent())
        {
            Haber dbHaber = optional.get();
            HaberResponseDto dto = new HaberResponseDto();
            dto.setId(dbHaber.getID());
            dto.setKonu(dbHaber.getKonu());
            dto.setIcerik(dbHaber.getIcerik());
            dto.setGecerlilikTarihi(dbHaber.getGecerlilikTarihi());
            dto.setHaberLinki(dbHaber.getHaberLinki());
            return dto;
        }

        throw new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND,ID.toString()));

    }
}
