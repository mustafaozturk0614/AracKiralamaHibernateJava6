package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.repository.entity.Kisi;
import com.bilgeadam.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {

    public KisiRepository() {
        super(new Kisi());
    }
    
}
