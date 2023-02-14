package com.bilgeadam.service;

import com.bilgeadam.repository.AracRepository;
import com.bilgeadam.repository.KisiRepository;
import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.repository.entity.Kisi;
import com.bilgeadam.utility.MyFactoryService;

public class KisiService extends MyFactoryService<KisiRepository, Kisi,Long> {


    public KisiService() {
        super(new KisiRepository());
    }
    
}
