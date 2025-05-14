package org.example.dernekwebsitesi.controller.impl;


import org.example.dernekwebsitesi.controller.AdminHaberController;
import org.example.dernekwebsitesi.dto.HaberRequestDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.example.dernekwebsitesi.service.impl.HaberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/admin/haber")

public class AdminHaberControllerImpl implements AdminHaberController {

    @Autowired
    HaberServiceImpl haberService;




}
