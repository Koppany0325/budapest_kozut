package com.example.budapest_kozut.service;


import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.model.Data;

public interface DataService {

    Data createData(DataDto data);

    Data modifyData(DataDto data, Long id);

    Data getById(Long id);

    void deleteById(Long id);


}
