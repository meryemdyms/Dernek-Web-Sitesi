package org.example.dernekwebsitesi.controller.impl;

import org.example.dernekwebsitesi.controller.UserDuyuruController;
import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.service.impl.DuyuruServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/duyuru")
@PreAuthorize("hasRole('USER')")
public class UserDuyuruControllerImpl implements UserDuyuruController {

    @Autowired
    DuyuruServiceImpl duyuruService;

    @GetMapping
    @Override
    public List<DuyuruResponseDto> listeleDuyurular() {
        return duyuruService.listeleDuyurular();
    }
}
