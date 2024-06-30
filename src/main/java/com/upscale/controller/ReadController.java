package com.upscale.controller;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvException;
import com.upscale.Repository.ConfigurationRepository;
import com.upscale.entity.POSTINGConfiguration;
import com.upscale.model.Input;
import com.upscale.model.Output;
import com.upscale.services.UpscaleService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ReadController {




    @Autowired
    UpscaleService upscaleService;


    @PostMapping("/csv")
    public String parseCSVs(@RequestParam MultipartFile file) throws IOException, CsvException {
        return upscaleService.processRequest(file);
    }



}
