package com.query.model;

import io.micronaut.data.annotation.MappedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "materi")
public class Materi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_materi")
    private String namaMateri;

    @Column(name = "kode_materi")
    private String kodeMateri;

    @Column(name = "nama_pengajar")
    private String namaPengajar;

}
