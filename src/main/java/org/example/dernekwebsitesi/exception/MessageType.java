package org.example.dernekwebsitesi.exception;

import lombok.Getter;

@Getter
public enum MessageType {


    RESOURCE_NOT_FOUND("1001", "Kayıt Bulunamadı"),

    FILE_STORAGE_ERROR("1003", "Dosya İşleme Hatası"),

    UNAUTHORIZED("1004", "Yetkisiz Erişim"),


    GENERAL_EXCEPTION("9999", "Genel Bir Hata Oluştu");

    private String code;

    private String message;


    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }



}
