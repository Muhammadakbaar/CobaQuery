package com.query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.query.model.Materi;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class KelasDto {

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

    @NotNull(message = "materi harus di isi.")
    private Set<Long> id_materi;
}
