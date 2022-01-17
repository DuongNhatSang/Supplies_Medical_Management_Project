package com.codegym.service.impl;

import com.codegym.model.TotalMoney;
import com.codegym.repository.ITotalMoneyRepository;
import com.codegym.service.ITotalMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalMoneyServiceImpl implements ITotalMoneyService {
    @Autowired
    ITotalMoneyRepository iTotalMoneyRepository;

    @Override
    public Long getTotalMoney() {
        return iTotalMoneyRepository.getTotalMoney();
    }

    @Override
    public void saveMoney(TotalMoney totalMoney) {
        iTotalMoneyRepository.save(totalMoney);
    }
}
