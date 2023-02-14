package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Kiralama;
import com.bilgeadam.service.KiralamaService;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }

    public Kiralama save(Kiralama kiralama) {

        return kiralamaService.save(kiralama);
    }
}
