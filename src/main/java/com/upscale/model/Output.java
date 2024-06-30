package com.upscale.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Output {
    @CsvBindByName(column = "Account",required = false)
    private  String Account;

    @CsvBindByName(column = "Posting Account",required = false)
    private  String Posting_Account;

    @CsvBindByName(column = "Value Date",required = false)
    private  String Value_Date;

    @CsvBindByName(column = "Cusip",required = false)
    private  String Cusip;

    @CsvBindByName(column = "Security Description",required = false)
    private  String Security_Description;

    @CsvBindByName(column = "Symbol",required = false)
    private  String Symbol;

    @CsvBindByName(column = "Sedol",required = false)
    private  String Sedol;

    @CsvBindByName(column = "ISIN",required = false)
    private  String ISIN;

    @CsvBindByName(column = "Currency",required = false)
    private  String Currency;

    @CsvBindByName(column = "Country",required = false)
    private  String Country;

    @CsvBindByName(column = "Bal Type",required = false)
    private  String Bal_Type;

    @CsvBindByName(column = "Type",required = false)
    private  String Type;

    @CsvBindByName(column = "Temp",required = false)
    private  String Temp;

    @CsvBindByName(column = "Shares",required = false)
    private  String Shares;

    @CsvBindByName(column = "Collateral Price (Local)",required = false)
    private  String Collateral_Price;

    @CsvBindByName(column = "Collateral Value (Local)",required = false)
    private  String Collateral_Value;

    @CsvBindByName(column = "Benchmark Rate",required = false)
    private  String benchMarkRate;

    @CsvBindByName(column = "Spread",required = false)
    private  String spread;

    @CsvBindByName(column = "Benchmark Date",required = false)
    private  String benchMarkDate;

    @CsvBindByName(column = "Net Rate",required = false)
    private  String netRate;

    @CsvBindByName(column = "Rebate (Local)",required = false)
    private  String rebateLocal;

    @CsvBindByName(column = "SL Fee (Local)",required = false)
    private  String slFeeLocal;

    @CsvBindByName(column = "Net Borrow Fee (Local)",required = false)
    private  String netBorrowFee;

    @CsvBindByName(column = "Net Borrow Fee (Base)",required = false)
    private  String netBorrowFeebase;

    @CsvBindByName(column = "FX Rate",required = false)
    private  String fxRate;
}
