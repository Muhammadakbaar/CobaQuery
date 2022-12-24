package com.query.controller;

import com.query.dto.KelasDto;
import com.query.model.Kelas;
import com.query.model.Materi;
import com.query.repository.KelasRepository;
import com.query.repository.MateriRepository;
import com.query.service.KelasService;
import com.query.service.MateriService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Controller("/kelas")
public class KelasController {

    @Inject
    KelasService kelasService;

    @Get("/")
    public List<Kelas> getKelas(){
        return kelasService.getKelas();
    }
    @Post("/")
    public String addKelas(@Body KelasDto kelasDto){
        return kelasService.addKelas(kelasDto);
    }
    @Transactional
    @Put("/{id}")
    public String updateKelas(@Body Kelas kelas, @PathVariable Long id){
        return kelasService.updateKelas(kelas, id);
    }
    @Delete("/{id}")
    public String deleteKelas(@PathVariable Long id){
        return kelasService.deleteKelas(id);
    }
}
