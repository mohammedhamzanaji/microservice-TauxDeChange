package com.operationchange.microtransaction.controller;

import com.operationchange.microtransaction.dao.OperationDeChangeDao;
import com.operationchange.microtransaction.model.OperationDeChange;
import com.operationchange.microtransaction.model.TauxDeChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.net.URI;
import java.util.Map;

@RestController
public class OperationDeChangeController {

    @Autowired
    private OperationDeChangeDao operationDeChangeDao;

    //OperationDeChange
    @GetMapping(value = "OperationDeChange")
    public List<OperationDeChange> listeTauxDeChange(){ return operationDeChangeDao.findAll();  }



    //OperationDeChange/{id}
    @GetMapping(value = "OperationDeChange/{id}")
    public OperationDeChange afficherOperationDeChange(@PathVariable int id){

        return operationDeChangeDao.findById(id);

    }

    @PostMapping(value = "OperationDeChange")
    public ResponseEntity<Void> creerOperationDeChange(@RequestBody OperationDeChange operationDeChange){


        OperationDeChange operationDeChange1 = operationDeChangeDao.save(operationDeChange);

        //Tester si l'operation a bien été ajouté
        if (operationDeChange == null) {
            return ResponseEntity.noContent().build();
        }

        //ServletUriComponentsBuilder : permet de créer un lien à partir d'une requête
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(operationDeChange1.getId())
                .toUri();

        return ResponseEntity.created(location).build(); // retourne l'uri correspondant à l'operation de change avec le bon id
    }

    @GetMapping(value = "OperationDeChange/fromRate/{id}")
    public TauxDeChange getTaux(@PathVariable int id) {
        Map<String, Integer> uriVariables = new HashMap<>();
        uriVariables.put("id", id);
        String url = "http://localhost:9090/TauxDeChange/{id}";
        RestTemplate restTemplate = new RestTemplate();
        TauxDeChange taux1 = restTemplate.getForObject(url, TauxDeChange.class, uriVariables);
        return taux1;
    }

}
