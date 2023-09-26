package com.example.budapest_kozut.service;


import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.model.Data;

import java.util.List;

public interface DataService {

    Data createData(DataDto data);

    Data modifyData(DataDto data, Long id);

    Data getById(Long id);

    List<Data> listData();

    void deleteById(Long id);


}
