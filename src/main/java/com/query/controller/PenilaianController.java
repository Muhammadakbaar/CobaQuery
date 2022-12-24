package com.query.controller;

import com.query.model.Materi;
import com.query.model.Penilaian;
import com.query.service.PenilaianService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.transaction.Transactional;

@Controller("/penilaian")
public class PenilaianController {

    @Inject
    PenilaianService penilaianService;

    @Get("/")
    public Iterable<Penilaian> getPenilaian(){
        return penilaianService.getPenilaian();
    }

    @Post("/")
    public String savePenilaian(@Body Penilaian penilaian){
        return penilaianService.addPenilaian(penilaian);
    }

    @Transactional
    @Put("/{id}")
    public String updatePenilaian(@Body Penilaian penilaian, @PathVariable Long id){
        boolean status = penilaianService.update(penilaian, penilaian.getId());
        if(status){
            return "Nilai berhasil diupdate";
        }
        else {
            return "Nilai tidak ditemukan";
        }
    }

    @Delete("/{id}")
    public String deletePenilaian(@PathVariable Long id){
        return penilaianService.deletePenilaian(id);
    }
}
