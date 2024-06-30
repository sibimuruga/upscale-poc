package com.upscale.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.Rate;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class Input {
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

    @CsvBindByName(column = "Collateral Price",required = false)
    private  String Collateral_Price;

    @CsvBindByName(column = "Collateral Value",required = false)
    private  String Collateral_Value;

    @CsvBindByName(column = "Base Rate",required = false)
    private  String Base_Rate;

    @CsvBindByName(column = "Gross Rebate",required = false)
    private  String Gross_Rebate;

    @CsvBindByName(column = "Stock Loan Fee",required = false)
    private  String Stock_Loan_Fee;

    @CsvBindByName(column = "Stock Loan Cost",required = false)
    private  String Stock_Loan_Cost;

    @CsvBindByName(column = "Net Rebate Rate",required = false)
    private  String Net_Rebate_Rate;

    @CsvBindByName(column = "Net Rebate",required = false)
    private  String Net_Rebate;

    @CsvBindByName(column = "Net Fee",required = false)
    private  String Net_Fee;

    @CsvBindByName(column = "Net Borrow Cost",required = false)
    private  String Net_Borrow_Cost;

    @CsvBindByName(column = "Closing Price",required = false)
    private  String Closing_Price;

    @CsvBindByName(column = "Base Collateral Price",required = false)
    private  String Base_Collateral_Price;

    @CsvBindByName(column = "Base Collateral Value",required = false)
    private  String Base_Collateral_Value;

    @CsvBindByName(column = "Base Gross Rebate",required = false)
    private  String Base_Gross_Rebate;

    @CsvBindByName(column = "Base Stock Loan Cost",required = false)
    private  String Base_Stock_Loan_Cost;

    @CsvBindByName(column = "Base Net Rebate",required = false)
    private  String Base_Net_Rebate;

    @CsvBindByName(column = "Base Net Borrow Cost",required = false)
    private  String Base_Net_Borrow_Cost;

    @CsvBindByName(column = "Account Type",required = false)
    private  String Account_Type;

    @CsvBindByName(column = "RIC",required = false)
    private  String RIC;

    @CsvBindByName(column = "Total Base Stock Loan Cost",required = false)
    private  String Total_Base_Stock_Loan_Cost;

    @CsvBindByName(column = "Total Base Net Rebate",required = false)
    private  String Total_Base_Net_Rebate;

    @CsvBindByName(column = "Total Base Net Borrow Cost",required = false)
    private  String Total_Base_Net_Borrow_Cost;






@Override
public boolean equals(Object obj)
{
    if (obj == null)
        return false;
    if (obj == this)
        return true;
    return ((this.getPosting_Account() == ((Input) obj). getPosting_Account())  && (this.getCusip() == ((Input) obj). getCusip()));
}








}
