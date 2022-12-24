package com.query.service;

import com.query.model.Materi;
import com.query.repository.MateriRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class MateriService {

    @Inject
    MateriRepository materiRepository;

   public List<Materi>getMateri(){
       return (List<Materi>) materiRepository.findAll();
   }

   public String addMateri(Materi materi){
       materiRepository.save(materi);
       return "Berhasil Mmembuat materi";
   }

   public String updateMateri(Materi materi, Long id){
       Optional<Materi> optional = materiRepository.findById(id);
       Materi m = optional.get();

       if(m != null){
            m.setNamaMateri(materi.getNamaMateri());
            m.setKodeMateri(materi.getKodeMateri());
            m.setNamaPengajar(materi.getNamaPengajar());

            materiRepository.save(m);
            return "Berhasil edit materi";
   }else {
           return "Gagal edit materi";
       }
   }
    public String deleteMateri(Long id){
       Optional<Materi> materi = materiRepository.findById(id);
       Materi m = materi.get();
       if(m != null){
           materiRepository.deleteById(id);
           return "Behasil menghapus materi " + id;
       }else {
           return "Gagal menghapus materi";
       }
    }
}
