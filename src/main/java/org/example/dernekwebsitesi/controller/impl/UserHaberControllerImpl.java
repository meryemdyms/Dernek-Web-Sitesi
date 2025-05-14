package org.example.dernekwebsitesi.controller.impl;

import org.example.dernekwebsitesi.controller.UserHaberController;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.service.impl.HaberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/haber")

public class UserHaberControllerImpl implements UserHaberController {

    @Autowired
    HaberServiceImpl haberService;

    @GetMapping
    @Override
    public List<HaberResponseDto> listeleHaberler() {
        return haberService.listeleHaberler();
    }

    @GetMapping("{id}")
    @Override
    public HaberResponseDto haberBilgi(@PathVariable(name = "id") Long ID) {
        return haberService.haberBilgi(ID);
    }
}
