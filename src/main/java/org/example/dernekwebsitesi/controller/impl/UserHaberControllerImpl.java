package org.example.dernekwebsitesi.controller.impl;

import org.example.dernekwebsitesi.controller.UserHaberController;
import org.example.dernekwebsitesi.service.impl.HaberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/haber")

public class UserHaberControllerImpl implements UserHaberController {

    @Autowired
    HaberServiceImpl haberService;

}
