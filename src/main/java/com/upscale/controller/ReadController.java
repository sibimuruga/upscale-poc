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
    ConfigurationRepository cofiguration;


    @PostMapping("/csvs")
    public String parseCSV(@RequestParam MultipartFile file) throws IOException, CsvException {

        Reader reader = new InputStreamReader(file.getInputStream());
        Map<String, String> mapping = new
                HashMap<String, String>();
        mapping.put("Account", "Account");
        mapping.put("Posting Account", "Posting_Account");
        mapping.put("Value Date", "Value_Date");
        mapping.put("Cusip", "Cusip");
        mapping.put("Security Description", "Security_Description");
        mapping.put("Symbol", "Symbol");
        mapping.put("Sedol", "Sedol");
        mapping.put("ISIN", "ISIN");
        mapping.put("Currency", "Currency");
        mapping.put("Country", "Country");
        mapping.put("Bal Type", "Bal_Type");
        mapping.put("Type", "Type");
        mapping.put("Temp", "Temp");
        mapping.put("Shares", "Shares");
        mapping.put("Collateral Price", "Collateral_Price");
        mapping.put("Collateral_Value", "Collateral_Value");
        mapping.put("Base Rate", "Base_Rate");
        mapping.put("Gross_Rebate", "Gross_Rebate");
        mapping.put("Stock Loan Fee", "Stock_Loan_Fee");
        mapping.put("Stock_Loan_Cost", "Stock_Loan_Cost");
        mapping.put("Net Rebate Rate", "Net_Rebate_Rate");
        mapping.put("Net_Rebate", "Net_Rebate");
        mapping.put("Net Fee", "Net_Fee");
        mapping.put("Net Borrow Cost", "Net_Borrow_Cost");
        mapping.put("Closing Price", "Closing_Price");
        mapping.put("Base Collateral Price", "Base_Collateral_Price");
        mapping.put("Base Collateral Value", "Base_Collateral_Value");
        mapping.put("Base Gross Rebate", "Base_Gross_Rebate");
        mapping.put("Base Stock Loan Cost", "Base_Stock_Loan_Cost");
        mapping.put("Base Net Rebate", "Base_Net_Rebate");
        mapping.put("Base Net Borrow Cost", "Base_Net_Borrow_Cost");
        mapping.put("Account Type", "Account_Type");
        mapping.put("RIC", "RIC");
        mapping.put("Total Base Stock Loan Cost", "Total_Base_Stock_Loan_Cost");
        mapping.put("Total Base Net Rebate", "Total_Base_Net_Rebate");
        mapping.put("Total Base Net Borrow Cost", "Total_Base_Net_Borrow_Cost");


        // Parse CSV data
        // CSVReader csvReader = new CSVReaderBuilder(reader).build();
        //List<String[]> rows = csvReader.readAll();
        HeaderColumnNameTranslateMappingStrategy<Input> strategy =
                new HeaderColumnNameTranslateMappingStrategy<Input>();
        strategy.setType(Input.class);
        strategy.setColumnMapping(mapping);
        List<Input> bindingSets = new CsvToBeanBuilder<Input>(reader)
                .withType(Input.class)
                .withMappingStrategy(strategy)
                .withSeparator(',')
                .build().parse();
        CsvToBean<Input> csvReaders = new CsvToBeanBuilder(reader)
                .withType(Input.class)
                .withMappingStrategy(strategy)
                .withIgnoreEmptyLine(false)
                .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                .build();
        List<Input> results = csvReaders.parse();

        for (Input x : bindingSets) {
            System.out.println(x);
        }
        return "Processed ";// +// rows.size() + " rows!";
    }

    @PostMapping("/csv")
    public String parseCSVs(@RequestParam MultipartFile file) throws IOException, CsvException {
        List<Input> models;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Input.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            models = (List<Input>) csvToBean.parse();
        } catch (Exception ex) {
            System.out.println("error parsing csv file {} ");
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getCause().getMessage());
        }

        List<Output> output = doBusinessLogic(models);


        return new Gson().toJson(output);
    }

    private List<Output> doBusinessLogic(List<Input> list) {
        List<Output> outputList = new ArrayList<>();
        List<POSTINGConfiguration> conf = cofiguration.getByclientName("UPSCALE");

        // Group the list by Posting Account and cul
        Map<String, Optional<Input>> latestInputsForAccountAndCul = list.stream()
                .collect(
                        Collectors.groupingBy(
                                input -> input.getPosting_Account() + "-" + input.getCusip(), // Unique Key
                                Collectors.maxBy(Comparator.comparing(Input::getValue_Date))));   // Select max date

        // Prints the latest objects for each combination of Posting_Account and cul
        latestInputsForAccountAndCul.forEach((inputKey, inputOptional) -> {
            Output singleOutputObject = new Output();
            Input input = inputOptional.get(); // as we know there's at least one input
            firstColumn(input, singleOutputObject);
            secondColumn(input, singleOutputObject, conf);
            fourthColumn(input, singleOutputObject);
            fiveColumn(input, singleOutputObject);
           sixColumn(input, singleOutputObject);
            sevenColumn(input, singleOutputObject);
            eightColumn(input, singleOutputObject);
            nineColumn(input, singleOutputObject);
            tenColumn(input, singleOutputObject);
            elevenColumn(input, singleOutputObject);

            outputList.add(singleOutputObject);
        });








return outputList;
    }

    private void fourthColumn(Input object, Output outputObject) {
        outputObject.setCusip(object.getCusip());
    }

    private void fiveColumn(Input object, Output outputObject) {
        outputObject.setSecurity_Description(object.getSecurity_Description());
    }

    private void sixColumn(Input object, Output outputObject) {
        outputObject.setSymbol(object.getSymbol());
    }

    private void sevenColumn(Input object, Output outputObject) {
        outputObject.setSedol(object.getSedol());
    }

    private void eightColumn(Input object, Output outputObject) {
        outputObject.setISIN(object.getISIN());
    }

    private void nineColumn(Input object, Output outputObject) {
        outputObject.setCurrency(object.getCurrency());
    }

    private void tenColumn(Input object, Output outputObject) {
        outputObject.setCountry(object.getCountry());
    }

    private void elevenColumn(Input object, Output outputObject) {
        outputObject.setBal_Type(object.getBal_Type());
    }

    /*
    *To-DOPOSTING ACCOUNT and CUSIP combination 1 value
    * C & E column  only unique record
    *
    * in C column max date --> shares in column N
    * if (O 'oo'column
    *
     */



    private void firstColumn(Input object, Output outputObject) {
         //To-Do -- Based upon the client data, this name sjould be adjusted
        outputObject.setAccount("PORTFOLIO NAME");

    }


    private void secondColumn(Input singleObject, Output singleOutputObject, List<POSTINGConfiguration> conf ) {
    for (POSTINGConfiguration c : conf ){
        if(c.getPostingCondition().equalsIgnoreCase(singleObject.getPosting_Account())){
            singleOutputObject.setPosting_Account(c.getPostingValue());
            return;
        }
        }
    }

}
