package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Kisi;
import com.bilgeadam.service.KisiService;

import java.util.Optional;

public class KisiController {

    private KisiService kisiService;

    public KisiController() {
        this.kisiService = new KisiService();
    }
    public Kisi save(String name, String username, String password) {
        return kisiService.save(Kisi.builder().name(name).password(password).username(username).build());
    }

    public Kisi findById(Long userId) {
     Optional<Kisi> kisi= kisiService.findById(userId);
     if (kisi.isPresent()){
         return  kisi.get();
     }else {
         throw  new RuntimeException("Kişi Bulunamdı");
     }
    }
}
