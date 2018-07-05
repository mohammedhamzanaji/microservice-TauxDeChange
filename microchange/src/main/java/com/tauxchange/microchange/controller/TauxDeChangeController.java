package com.tauxchange.microchange.controller;


import com.tauxchange.microchange.dao.TauxDeChangeDao;
import com.tauxchange.microchange.model.TauxDeChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TauxDeChangeController {

    @Autowired
    private TauxDeChangeDao tauxDeChangeDao;

    //TauxDeChange
    @GetMapping(value = "TauxDeChange")
    public List<TauxDeChange> listeTauxDeChange(){ return tauxDeChangeDao.findAll();  }


    //TauxDeChange/{id}
    @GetMapping(value = "TauxDeChange/{id}")
    public TauxDeChange afficherTauxDeChange(@PathVariable int id){

        return tauxDeChangeDao.findById(id);

    }

    @PostMapping(value = "TauxDeChange")
    public ResponseEntity<Void> creerTauxDeChange(@RequestBody TauxDeChange tauxDeChange){


        TauxDeChange tauxDeChange1 = tauxDeChangeDao.save(tauxDeChange);

        //Tester si le taux a bien été ajouté
        if (tauxDeChange == null) {
            return ResponseEntity.noContent().build();
        }

        //ServletUriComponentsBuilder : permet de créer un lien à partir d'une requête
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tauxDeChange1.getId())
                .toUri();

        return ResponseEntity.created(location).build(); // retourne l'uri correspondant au taux de change avec le bon id
    }



}
