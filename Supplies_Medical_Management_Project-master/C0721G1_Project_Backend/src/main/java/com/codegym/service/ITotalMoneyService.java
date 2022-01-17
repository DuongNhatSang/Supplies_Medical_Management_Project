package com.codegym.service;

import com.codegym.model.TotalMoney;

public interface ITotalMoneyService {
    Long getTotalMoney();
    void saveMoney(TotalMoney totalMoney);
}
