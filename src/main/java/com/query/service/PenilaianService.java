package com.query.service;

import com.query.model.Materi;
import com.query.model.Penilaian;
import com.query.repository.PenilaianRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class PenilaianService {

    @Inject
    PenilaianRepository penilaianRepository;

    public Iterable<Penilaian> getPenilaian(){
        return penilaianRepository.findAll();
    }
    public String addPenilaian(Penilaian penilaian){
        Penilaian penilaian1 =  penilaianRepository.save(penilaian);
        if(penilaian1 != null){
            return "Berhasil menyimpan nilai";
        }
        else {
            return "Gagal menyimpan nilai";
        }
    }
    public boolean update (Penilaian penilaian, Long id){
        Optional<Penilaian> penilaian1 = penilaianRepository.findById(id);
        Penilaian penilaian2 = penilaian1.get();

        if(penilaian2 != null){
            penilaian2.setId(penilaian.getId());
            penilaian2.setNilaiPeserta(penilaian.getNilaiPeserta());

            penilaianRepository.save(penilaian2);
            return true;
        }else {
            return false;
        }
    }
    public String deletePenilaian(Long id){
        Optional<Penilaian> penilaian = penilaianRepository.findById(id);
        Penilaian penilaian1 = penilaian.get();

        if(penilaian1 != null){
            penilaianRepository.deleteById(id);
            return "Berhasil Menghapus Penilaian";
        }else {
            return "Penilaian dengan id "+id+" tidak ditemukan";
        }
    }
}
