package com.bilgeadam.utility;


import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.repository.entity.Kiralama;
import com.bilgeadam.repository.entity.Kisi;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtility {
    private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

    private static SessionFactory sessionFactoryHibernate() {
        try {
            Configuration configuration = new Configuration();

            //Yeni olusturdugumuz entity sınıflarımızı buraya ekliyoruz
            configuration.addAnnotatedClass(Arac.class);
            configuration.addAnnotatedClass(Kisi.class);
            configuration.addAnnotatedClass(Kiralama.class);


            SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return factory;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
