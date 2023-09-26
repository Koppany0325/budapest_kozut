package com.example.budapest_kozut.mapper;

import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.model.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataMapperImpl implements DataMapper {
    @Override
    public Data mapDtoToData(DataDto dataDto) {
        Data data = new Data();
        data.setAuthor(dataDto.getAuthor());
        data.setCreated(new Date());
        data.setPhoto(dataDto.getPhoto());
        data.setText(dataDto.getText());
        data.setTitle(dataDto.getTitle());
        return data;
    }


    @Override
    public Data mapDtoToDataForUpdate(DataDto dataDto, Data oldData) {
        oldData.setAuthor(dataDto.getAuthor());
        oldData.setModified(new Date());
        oldData.setPhoto(dataDto.getPhoto());
        oldData.setText(dataDto.getText());
        oldData.setTitle(dataDto.getTitle());
        return oldData;
    }
}
