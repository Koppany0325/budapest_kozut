package com.example.budapest_kozut.controller;

import com.example.budapest_kozut.dtos.DataDto;
import com.example.budapest_kozut.model.Data;
import com.example.budapest_kozut.service.DataService;
import com.example.budapest_kozut.util.FileUploadUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Validated
public class DataController {

    private final DataService dataService;

    @PostMapping("/saveData")
    public void saveData(JwtAuthenticationToken token, @Valid @ModelAttribute("data") DataDto data, @RequestParam(value = "image", required = false) MultipartFile multipartFile) throws IOException, NoSuchFieldException {
        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            data.setPhoto(fileName);
            data.setAuthor((String)token.getToken().getClaims().get("name"));
            Data saveData = dataService.createData(data);
            String uploadDir = "data-photo/" + saveData.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            data.setAuthor((String)token.getToken().getClaims().get("name"));
            dataService.createData(data);
        }
    }

    @DeleteMapping("/deleteData/{id}")
    public void deleteData(@PathVariable(value = "id") long id) {
        this.dataService.deleteById(id);
    }

    @GetMapping("/getData/{id}")
    public Data getData(@PathVariable(value = "id") long id) {
        return this.dataService.getById(id);
    }

    @GetMapping("/listData")
    public List<Data> listData() {
        return this.dataService.listData();
    }

    @PutMapping("/modifyData/{id}")
    public void modifyData(JwtAuthenticationToken token,@Valid @ModelAttribute("data") DataDto data, @RequestParam(value = "image", required = false) MultipartFile multipartFile, @PathVariable(value = "id") long id) throws IOException {
        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            data.setPhoto(fileName);
            data.setAuthor((String)token.getToken().getClaims().get("name"));
            Data saveData = dataService.modifyData(data, id);
            String uploadDir = "data-photo/" + saveData.getId();
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            data.setAuthor((String)token.getToken().getClaims().get("name"));
            dataService.modifyData(data, id);
        }
    }

}
