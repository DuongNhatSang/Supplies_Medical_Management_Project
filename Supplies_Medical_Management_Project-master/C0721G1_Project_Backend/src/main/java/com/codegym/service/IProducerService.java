package com.codegym.service;

import com.codegym.model.Producer;

import java.util.List;

public interface IProducerService extends IGenericService<Producer> {
    List<Producer> getAll();
}
