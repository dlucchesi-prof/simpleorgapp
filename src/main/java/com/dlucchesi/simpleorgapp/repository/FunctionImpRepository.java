package com.dlucchesi.simpleorgapp.repository;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.FunctionImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FunctionImpRepository extends JpaRepository<FunctionImp, Long> {

    @Query("SELECT f FROM Function f WHERE f.")
    List<FunctionImp> findByUser(User user);
}
