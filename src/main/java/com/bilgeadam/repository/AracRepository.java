package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.utility.MyFactoryRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class AracRepository extends MyFactoryRepository<Arac, Long> {

    public AracRepository() {
        super(new Arac());
    }

    public Arac findByMarkaAndModel(String marka, String model) {
        String hql = "select a from Arac a where a.marka=:x and model=:y";
        openSession();
        TypedQuery<Arac> typedQuery = getSs().createQuery(hql);
        typedQuery.setParameter("x", marka);
        typedQuery.setParameter("y", model);
        Arac arac;
        try {
            arac = typedQuery.getSingleResult();
            closeSession();
            return arac;
        } catch (Exception e) {
            closeSession();
            throw new RuntimeException("Arac bulunamadı");
        }
    }


    public List<Arac> findAllByDurum(boolean durum) {
        openSession();
        TypedQuery<Arac> typedQuery=getEntityManager()
                .createNamedQuery("findbydurum", Arac.class);
            typedQuery.setParameter("durum",durum);

        List<Arac> aracList =  typedQuery.getResultList();
           closeSession();
           return aracList;
    }
}
