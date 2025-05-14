package org.example.dernekwebsitesi.controller.impl;


import jakarta.validation.Valid;
import org.example.dernekwebsitesi.controller.AdminHaberController;
import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.service.impl.HaberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/admin/haber")

public class AdminHaberControllerImpl implements AdminHaberController {

    @Autowired
    HaberServiceImpl haberService;


    @PostMapping("/kaydet")
    @Override
    public HaberResponseDto kaydetHaber(@RequestBody @Valid HaberRequestDto haberDto) {
        return haberService.kaydetHaber(haberDto);
    }

    @DeleteMapping("/sil/{id}")
    @Override
    public void silHaber(@PathVariable(name = "id") Long ID) {

        haberService.silHaber(ID);
    }

    @PutMapping("/guncelle/{id}")
    @Override
    public HaberResponseDto guncelleHaber(@PathVariable(name = "id") Long ID,@RequestBody @Valid HaberRequestDto haberDto) {
        return haberService.guncelleHaber(ID,haberDto);
    }
}
