package org.example.dernekwebsitesi.controller.impl;

import jakarta.validation.Valid;
import org.example.dernekwebsitesi.controller.AdminDuyuruController;
import org.example.dernekwebsitesi.dto.DuyuruRequestDto;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.service.impl.DuyuruServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin/duyuru")
@PreAuthorize("hasRole('ADMIN')")
public class AdminDuyuruControllerImpl implements AdminDuyuruController {

    @Autowired
    DuyuruServiceImpl duyuruService;

    @PostMapping(
            path = "/kaydet",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DuyuruResponseDto kaydetDuyuru(@ModelAttribute @Valid DuyuruRequestDto dto)
    {
        return duyuruService.kaydetDuyuru(dto);
    }

    @DeleteMapping("/sil/{id}")
    @Override
    public void silDuyuru(@PathVariable(name = "id") Long ID ) {

        duyuruService.silDuyuru(ID);
    }

    @PutMapping(path = "/güncelle/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    @Override
    public DuyuruResponseDto guncelleDuyuru(@PathVariable(name="id") Long ID, @ModelAttribute @Valid DuyuruRequestDto dto)  {
        return duyuruService.guncelleDuyuru(ID,dto);
    }
}
