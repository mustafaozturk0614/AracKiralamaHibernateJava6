package com.bilgeadam.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "arac_id")
    private Arac arac;
    @ManyToOne
    private Kisi kisi;

}
