package com.bilgeadam;

import com.bilgeadam.controller.AracController;
import com.bilgeadam.controller.KiralamaController;
import com.bilgeadam.controller.KisiController;
import com.bilgeadam.repository.entity.Arac;
import com.bilgeadam.repository.entity.Kiralama;
import com.bilgeadam.repository.entity.Kisi;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner=new Scanner(System.in);
    AracController aracController=new AracController();
    KisiController kisiController=new KisiController();
    KiralamaController kiralamaController=new KiralamaController();


    public static void main(String[] args) {
        Main main=new Main();
        main.anaMenu();

    }




    public void anaMenu(){

        int input=0;
        do {
            System.out.println("====ARAC KİRALAMA SİSTEMİ====");
            System.out.println("1-Arac Ekle");
            System.out.println("2-Arac Ara");
            System.out.println("3-Kisi Ekle");
            System.out.println("4-Kiralama Yap");
            System.out.println("5-Raporlama Menusu");
            System.out.println("0-Çıkış");
            System.out.println("Lütfen bir seçim yapınız");
            input=Integer.parseInt(scanner.nextLine());

            switch (input){

                case 1:
                    aracEkle();
                    break;
                case 2:
                    aracAra();
                    break;
                case 3:
                    kisiEkle();
                    break;

                case 4:
                    kiralamaYap();
                    break;

                case 5:
                    raporlamaMenusu();
                    break;
            }



        }while (input!=0);




    }

    private void raporlamaMenusu() {

        int input=0;

        do {
            System.out.println("======Raporlama======");
            System.out.println("1-Şuan Kirada olan araçlar");
            System.out.println("2-Boşta olan araçlar");
            System.out.println("3-Herhangi bir müşterinin kiraladığı araçlar");
            System.out.println("0-Ana Menu");
            input=Integer.parseInt(scanner.nextLine());
            switch (input){
                case 1:
                    kiradaOlanAraclar();
                    break;
                case 2:
                    bostaOlanAraclar();
                    break;
                case 3:
                    musteriyeGoreKiraladagiAraclar();
                    break;
            }

        }while (input!=0);

    }

    private void musteriyeGoreKiraladagiAraclar() {
        System.out.println("Lütfen müşteri id si giriniz");
        Long kisiId=Long.parseLong(scanner.nextLine());
        Kisi kisi=kisiController.findById(kisiId);
        kisi.getKiralamalar().forEach(x-> System.out.println(x.getArac()));

    }

    private void bostaOlanAraclar() {
        aracController.findAllByDurum(false).forEach(System.out::println);
    }

    private void kiradaOlanAraclar() {
        System.out.println("==Kirada Olan Araçlar");
      aracController.findAllByDurum(true).forEach(System.out::println);

    }

    private void kiralamaYap() {
   List<Arac> aracList= aracController.findAllByDurum(false);

   if (aracList.size()==0){
       System.out.println("Kiralanacak arac bulunmamaktadır");
   }else{
       aracList.forEach(System.out::println);
       System.out.println("Lütfen id degerine göre arac seciniz");
       Long id=Long.parseLong(scanner.nextLine());
       Arac arac= aracController.findById(id);
       System.out.println("Lütfen idnizi giriniz");
       Long userId=Long.parseLong(scanner.nextLine());
       Kisi kisi= kisiController.findById(userId);
       System.out.println("Kaç gün kiralanacak");
       int day=Integer.parseInt(scanner.nextLine());
       Kiralama kiralama=Kiralama.builder().arac(arac).kisi(kisi)
               .baslangicTarihi(LocalDate.now())
               .bitisTarihi(LocalDate.now().plusDays(day))
               .build();
       System.out.println(kiralamaController.save(kiralama));
       arac.setDurum(true);
       aracController.update(arac);
   }

    }

    private void aracAra() {
        System.out.println("Lütfen aracın markasını giriniz");
        String marka=scanner.nextLine();
        System.out.println("Lütfen aracın modelini giriniz");
        String model=scanner.nextLine();

        System.out.println(aracController.findByMarkaAndModel(marka,model));   ;


    }

    private void kisiEkle() {
        System.out.println("Lütfen isminizi giriniz");
        String name=scanner.nextLine();
        System.out.println("Lütfen kullanıcı isminizi giriniz");
        String username=scanner.nextLine();
        System.out.println("Lütfen şifrenizi giriniz");
        String password=scanner.nextLine();
        System.out.println(kisiController.save(name,username,password)); ;

    }

    private void aracEkle() {
        System.out.println("Lütfen aracın markasını giriniz");
        String marka=scanner.nextLine();
        System.out.println("Lütfen aracın modelini giriniz");
        String model=scanner.nextLine();
        System.out.println(aracController.save(marka,model));

    }


}