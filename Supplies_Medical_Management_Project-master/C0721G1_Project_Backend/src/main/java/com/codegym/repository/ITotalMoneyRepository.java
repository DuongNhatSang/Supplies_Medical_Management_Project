package com.codegym.repository;

import com.codegym.model.TotalMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ITotalMoneyRepository extends JpaRepository<TotalMoney,Long> {
    @Query(nativeQuery = true, value = "Select Sum(total_money) from c0721g1_project_sprint1_backend.total_money")
     Long getTotalMoney();
}
