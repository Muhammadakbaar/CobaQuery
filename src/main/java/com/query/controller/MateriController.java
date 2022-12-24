package com.query.controller;

import com.query.model.Materi;
import com.query.repository.MateriRepository;
import com.query.service.MateriService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;

@Controller("/materi")
public class MateriController {

    @Inject
    MateriService materiService;

    @Get("/")
    public List<Materi> getMateri(){
        return materiService.getMateri();
    }
    @Post("/")
    public String addMateri(@Body Materi materi){
        return materiService.addMateri(materi);
    }
    @Transactional
    @Put("/{id}")
    public String updateMateri(@Body Materi materi, @PathVariable Long id){
        return materiService.updateMateri(materi, id);
    }
    @Delete("/{id}")
    public String deleteMateri(@PathVariable Long id){
        return materiService.deleteMateri(id);
    }
}
