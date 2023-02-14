package com.bilgeadam.service;

import com.bilgeadam.repository.KiralamaRepository;
import com.bilgeadam.repository.KisiRepository;
import com.bilgeadam.repository.entity.Kiralama;
import com.bilgeadam.repository.entity.Kisi;
import com.bilgeadam.utility.MyFactoryService;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {

    public KiralamaService() {
        super(new KiralamaRepository());
    }




}
