package org.donate.entity.other;

import java.util.Map;

public class ConvertRateResponse {

    private String amount;

    private String base_currency_code;

    private String base_currency_name;

    private Map<String, ToCurrencyRate> rates;

    private String status;

    private String updated_date;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBase_currency_code() {
        return base_currency_code;
    }

    public void setBase_currency_code(String base_currency_code) {
        this.base_currency_code = base_currency_code;
    }

    public String getBase_currency_name() {
        return base_currency_name;
    }

    public void setBase_currency_name(String base_currency_name) {
        this.base_currency_name = base_currency_name;
    }

    public Map<String, ToCurrencyRate> getRates() {
        return rates;
    }

    public void setRates(Map<String, ToCurrencyRate> rates) {
        this.rates = rates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }
}
