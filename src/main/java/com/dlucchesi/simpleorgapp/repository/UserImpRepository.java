package com.dlucchesi.simpleorgapp.repository;

import com.dlucchesi.simpleorgapp.model.imp.UserImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImpRepository extends JpaRepository<UserImp, Long> {


}
