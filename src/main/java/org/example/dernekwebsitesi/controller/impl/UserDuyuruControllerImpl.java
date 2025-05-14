package org.example.dernekwebsitesi.controller.impl;

import org.example.dernekwebsitesi.controller.UserDuyuruController;
import org.example.dernekwebsitesi.service.impl.DuyuruServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/duyuru")
public class UserDuyuruControllerImpl implements UserDuyuruController {

    @Autowired
    DuyuruServiceImpl duyuruService;
}
