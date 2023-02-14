package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.service.AracService;

import java.util.List;
import java.util.Optional;

public class AracController {

    private AracService aracService;

    public AracController() {
        this.aracService = new AracService();
    }

    public Arac save(String marka, String model) {

     return  aracService.save(Arac.builder().marka(marka).model(model).build());

    }
    public void update(Arac arac) {

        aracService.update(arac);
    }

    public Arac findByMarkaAndModel(String marka, String model) {

        return  aracService.findByMarkaAndModel(marka,model);
    }

    public List<Arac> findAllByDurum(boolean durum) {

        return aracService.findAllByDurum(durum);

    }

    public Arac findById(Long id) {
     Optional<Arac> arac =aracService.findById(id);
     if (arac.isPresent()){
       return   arac.get();
     }else {
         throw  new RuntimeException("Arac bulunamadı");
     }
    }


}
