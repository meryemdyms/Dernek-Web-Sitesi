package org.example.dernekwebsitesi.service.impl;

import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.exception.BaseException;
import org.example.dernekwebsitesi.exception.ErrorMessage;
import org.example.dernekwebsitesi.exception.MessageType;
import org.example.dernekwebsitesi.mapper.DuyuruMapper;
import org.example.dernekwebsitesi.model.Duyuru;
import org.example.dernekwebsitesi.repository.DuyuruRepository;
import org.example.dernekwebsitesi.service.DuyuruService;
import org.example.dernekwebsitesi.websocket.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DuyuruServiceImpl implements DuyuruService {

    @Autowired
    DuyuruRepository duyuruRepository;
    @Autowired
    DuyuruMapper duyuruMapper;
    @Autowired
    FileStorageServiceImpl fileStorageService;

    @Autowired
    NotificationService notificationService;


    @Override
    public DuyuruResponseDto kaydetDuyuru(DuyuruRequestDto dto)  {


        String resimPath = fileStorageService.store(dto.getResim());
        Duyuru entity = duyuruMapper.dtoToEntity(dto, resimPath);
        Duyuru saved = duyuruRepository.save(entity);

        DuyuruResponseDto response = duyuruMapper.entityToDto(saved);
        notificationService.notifyNewDuyuru(response);
        return response;

    }

    @Override
    public void silDuyuru(Long ID) {

        Optional<Duyuru> optional = duyuruRepository.findById(ID);

        if(optional.isPresent())
        {
            duyuruRepository.delete(optional.get());

        }

        throw new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND,ID.toString()));

    }

    @Override
    public DuyuruResponseDto guncelleDuyuru(Long ID, DuyuruRequestDto dto)  {
        Optional<Duyuru> optional = duyuruRepository.findById(ID);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.RESOURCE_NOT_FOUND,ID.toString()));
        }
        Duyuru dbDuyuru = optional.get();


        dbDuyuru.setKonu(dto.getKonu());
        dbDuyuru.setIcerik(dto.getIcerik());
        dbDuyuru.setGecerlilikTarihi(dto.getGecerlilikTarihi());


        MultipartFile yeniResim = dto.getResim();
        if (yeniResim != null && !yeniResim.isEmpty()) {

                // Eski resmi sil
                String eskiUrl = dbDuyuru.getResimUrl();
                String eskiDosya = eskiUrl.startsWith("/") ? eskiUrl.substring(1) : eskiUrl;
                fileStorageService.delete(eskiDosya);

                // Yeni resmi kaydet
                String yeniAdi = fileStorageService.store(yeniResim);
                String yeniUrl = yeniAdi.startsWith("/") ? yeniAdi : ("/" + yeniAdi);
                dbDuyuru.setResimUrl(yeniUrl);



            }



        Duyuru saved = duyuruRepository.save(dbDuyuru);
        DuyuruResponseDto response = duyuruMapper.entityToDto(saved);
        notificationService.notifyNewDuyuru(response);
        return response;
    }

    @Override
    public List<DuyuruResponseDto> listeleDuyurular() {

        List<DuyuruResponseDto> duyuruDtoList = new ArrayList<>();
        List<Duyuru> duyuruList = duyuruRepository.findAll();

        for (Duyuru duyuru : duyuruList)
        {
            DuyuruResponseDto dto = duyuruMapper.entityToDto(duyuru);
            duyuruDtoList.add(dto);
        }

        return duyuruDtoList;
    }
}
