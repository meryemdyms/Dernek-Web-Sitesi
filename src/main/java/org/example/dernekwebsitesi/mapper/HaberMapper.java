package org.example.dernekwebsitesi.mapper;

import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.model.Haber;
import org.springframework.stereotype.Component;

@Component
public class HaberMapper {

    public Haber dtoToEntity(HaberRequestDto dto)
    {
        Haber haber = new Haber();
        haber.setKonu(dto.getKonu());
        haber.setIcerik(dto.getIcerik());
        haber.setGecerlilikTarihi(dto.getGecerlilikTarihi());
        haber.setHaberLinki(dto.getHaberLinki());

        return haber;

    }

    public HaberResponseDto entityToDto(Haber haber)
    {
        return new HaberResponseDto(
                haber.getID(),
                haber.getKonu(),
                haber.getIcerik(),
                haber.getGecerlilikTarihi(),
                haber.getHaberLinki()

        );
    }

}
