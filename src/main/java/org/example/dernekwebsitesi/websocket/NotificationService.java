package org.example.dernekwebsitesi.websocket;

import org.example.dernekwebsitesi.dto.DuyuruResponseDto;
import org.example.dernekwebsitesi.dto.HaberResponseDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final SimpMessagingTemplate template;
    public NotificationService(SimpMessagingTemplate template) {
        this.template = template;
    }
    public void notifyNewHaber(HaberResponseDto dto) {
        template.convertAndSend("/topic/haberler", dto);
    }
    public void notifyNewDuyuru(DuyuruResponseDto dto) {
        template.convertAndSend("/topic/duyurular", dto);
    }
}
