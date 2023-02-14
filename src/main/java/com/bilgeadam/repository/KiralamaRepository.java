package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Kiralama;
import com.bilgeadam.repository.entity.Kisi;
import com.bilgeadam.utility.MyFactoryRepository;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {

    public KiralamaRepository() {
        super(new Kiralama());
    }
    
}
