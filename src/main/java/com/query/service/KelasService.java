package com.query.service;

import com.query.dto.KelasDto;
import com.query.model.Kelas;
import com.query.model.Materi;
import com.query.repository.KelasRepository;
import com.query.repository.MateriRepository;
import io.micronaut.http.annotation.Body;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Singleton
public class KelasService {

    @Inject
    KelasRepository kelasRepository;

    @Inject
    MateriRepository materiRepository;

    public List<Kelas>getKelas(){
        return (List<Kelas>) kelasRepository.findAll();
    }

    public String addKelas(KelasDto kelasDto){
       Set<Long> materiIdList = kelasDto.getId_materi();
        List<Materi> materiList = new ArrayList<>();
        materiIdList.forEach(m -> {
            Optional<Materi> materi = materiRepository.findById(m);
            if (materi.isPresent()) {
                materiList.add(materi.get());
            }
        });
        Kelas kelas = Kelas.builder()
             .namaKelas(kelasDto.getNamaKelas())
             .kodeKelas(kelasDto.getKodeKelas())
             .tanggalMulai(kelasDto.getTanggalMulai())
             .jumlahPertemuan(kelasDto.getJumlahPertemuan())
             .biaya(kelasDto.getBiaya())
                .materi(materiList)
             .build();
     Kelas result = kelasRepository.save(kelas);
        return "" + result;
    }

    public String updateKelas(Kelas kelas, Long id){
        Optional<Kelas> optional = kelasRepository.findById(id);
        Kelas k = optional.get();

        if(k != null){
            k.setNamaKelas(kelas.getNamaKelas());
            k.setKodeKelas(kelas.getKodeKelas());
            k.setTanggalMulai(kelas.getTanggalMulai());
            k.setJumlahPertemuan(kelas.getJumlahPertemuan());
            k.setBiaya(k.getBiaya());

            kelasRepository.save(k);
            return "Berhasil edit Kelas";
        }else {
            return "Gagal edit kelas";
        }
    }
    public String deleteKelas(Long id){
        Optional<Kelas> kelas = kelasRepository.findById(id);
        Kelas k = kelas.get();
        if(k != null){
            kelasRepository.deleteById(id);
            return "Behasil menghapus kelas " + id;
        }else {
            return "Gagal menghapus kelas";
        }
    }
}
