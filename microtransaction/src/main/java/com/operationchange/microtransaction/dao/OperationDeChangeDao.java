package com.operationchange.microtransaction.dao;

import com.operationchange.microtransaction.model.OperationDeChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDeChangeDao extends JpaRepository<OperationDeChange, Integer> {

    OperationDeChange findById(int id);
}
