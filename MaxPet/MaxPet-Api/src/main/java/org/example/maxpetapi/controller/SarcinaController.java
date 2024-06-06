package org.example.maxpetapi.controller;

import org.example.maxpetapi.Models.Sarcina;
import org.example.maxpetapi.Models.User;
import org.example.maxpetapi.Response.Response;
import org.example.maxpetapi.Service.SarcinaService;
import org.example.maxpetapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sarcina")
public class SarcinaController {
    private final SarcinaService sarcinaService;

    @Autowired
    public SarcinaController(SarcinaService sarcinaService) {
        this.sarcinaService = sarcinaService;
    }
    @PostMapping("/new")
    public Response addSarcina(Sarcina sarcina){
        return sarcinaService.adaugareSarcina(sarcina);
    }
    @PostMapping("/delete")
    public Response deleteSarcina(int id){
        return sarcinaService.deleteSarcinaById(id);
    }
    @DeleteMapping("/delete/completa")
    public Response deleteSacrinaCompleta(Sarcina sarcina){
        return sarcinaService.deleteCompletedSarcina(sarcina);
    }
    @PostMapping("/update/activ")
    public Response updateActiv(Sarcina sarcina){
        return sarcinaService.updateSarcinaActiv(sarcina);
    }
    @PostMapping("/update/cerinta")
    public Response updateCerinta(Sarcina sarcina){
        return sarcinaService.updateSarcinaCerinta(sarcina);
    }
    @PostMapping("SarcinaListCompletedLast")
    public Response sarcinaListCompletedLast(Sarcina sarcina){
        return sarcinaService.sarcinaListCompletedLast(sarcina);
    }
    @PostMapping("SarcinaListOldestToNewest")
    public Response sarcinaListOldestToNewest(Sarcina sarcina){
        return sarcinaService.SarcinaListOldestToNewest(sarcina);
    }

}
