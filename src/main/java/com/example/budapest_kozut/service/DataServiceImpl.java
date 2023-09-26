package com.example.budapest_kozut.service;

import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.mapper.DataMapper;
import com.example.budapest_kozut.model.Data;
import com.example.budapest_kozut.repo.DataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepo dataRepo;
    private final DataMapper dataMapper;


    @Override
    public Data createData(DataDto data) {
        return dataRepo.save(dataMapper.mapDtoToData(data));
    }

    @Override
    public Data modifyData(DataDto data, Long id) {
        return dataRepo.save(dataMapper.mapDtoToDataForUpdate(data, getById(id)));
    }

    @Override
    public Data getById(Long id) {
        return dataRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        dataRepo.deleteById(id);
    }
}
