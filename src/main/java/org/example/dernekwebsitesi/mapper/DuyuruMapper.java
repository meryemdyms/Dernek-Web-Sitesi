package org.example.dernekwebsitesi.mapper;

import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.model.Duyuru;
import org.springframework.stereotype.Component;

@Component
public class DuyuruMapper {

    public Duyuru dtoToEntity(DuyuruRequestDto dto, String resimPath)
    {
        Duyuru duyuru = new Duyuru();
        duyuru.setKonu(dto.getKonu());
        duyuru.setIcerik(dto.getIcerik());
        duyuru.setGecerlilikTarihi(dto.getGecerlilikTarihi());
        duyuru.setResimUrl(resimPath);
        return duyuru;
    }

    public DuyuruResponseDto entityToDto(Duyuru duyuru){
        return new DuyuruResponseDto(
                duyuru.getID(),
                duyuru.getKonu(),
                duyuru.getIcerik(),
                duyuru.getGecerlilikTarihi(),
                duyuru.getResimUrl()
        );
    }

}