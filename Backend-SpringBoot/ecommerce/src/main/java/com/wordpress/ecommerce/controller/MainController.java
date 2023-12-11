package com.wordpress.ecommerce.controller;

import com.wordpress.ecommerce.service.CreateEcommerceData;
import com.wordpress.ecommerce.service.DataImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
    @Autowired
    CreateEcommerceData createEcommerceData;
    @Autowired
    DataImportService dataImportService;
    @GetMapping("/addData")
    public ResponseEntity<?> addDataInNeo4j() throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        return new ResponseEntity<>(dataImportService.importDataFromJsonAndSave("ecomm.json"), HttpStatus.OK);
    }

    @GetMapping("/generate")
    public ResponseEntity<?> create() throws IOException {
        return new ResponseEntity<>(createEcommerceData.ecommerceData("data1.json", "data2.json", "ecomm.json"), HttpStatus.OK);
    }

    @GetMapping("/generateCSV")
    public ResponseEntity<?> createCSV() throws IOException {
        return new ResponseEntity<>(createEcommerceData.jsonToCsv("ecomm.json", "ecomm.csv"), HttpStatus.OK);
    }
}
