package com.bilgeadam.service;

import com.bilgeadam.repository.AracRepository;
import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.utility.MyFactoryService;

import java.util.List;

public class AracService extends MyFactoryService<AracRepository, Arac,Long> {


    public AracService() {
        super(new AracRepository());
    }

    public Arac findByMarkaAndModel(String marka, String model) {

        return getRepository().findByMarkaAndModel(marka,model);
    }

    public List<Arac> findAllByDurum(boolean durum) {

        return  getRepository().findAllByDurum(durum);
    }
}
