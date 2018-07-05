package com.tauxchange.microchange.dao;

import com.tauxchange.microchange.model.TauxDeChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxDeChangeDao extends JpaRepository<TauxDeChange, Integer> {

    TauxDeChange findById(int id);

}
