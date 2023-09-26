package com.example.budapest_kozut.mapper;

import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.model.Data;

public interface DataMapper {

    Data mapDtoToData(DataDto dataDto);

    Data mapDtoToDataForUpdate(DataDto dataDto, Data oldData);
}
