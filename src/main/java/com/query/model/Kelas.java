package com.query.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "kelas")
public class Kelas {

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Materi.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "kelas_materi",
            joinColumns = @JoinColumn(name = "id_kelas"),
            inverseJoinColumns = @JoinColumn(name = "id_materi"))
    private List<Materi> materi;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nama_kelas")
    private String namaKelas;

    @Column(name = "kode_kelas")
    private String kodeKelas;

    @Column(name = "tanggal_mulai")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date tanggalMulai;

    @Column(name = "jumlah_pertemuan")
    private String jumlahPertemuan;

    @Column(name = "biaya")
    private Float biaya;
}
