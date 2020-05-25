package com.rsjava.converter.service;

import com.google.gson.Gson;
import com.rsjava.converter.model.NbpModel;
import com.rsjava.converter.model.Rate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class CurrencyService {

    public List<Rate> getAllRates() {
        InputStreamReader reader = null;
        try {
            URL url = new URL("https://api.nbp.pl/api/exchangerates/tables/a/?format=json");
            reader = new InputStreamReader(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return new Gson().fromJson(reader, NbpModel[].class)[0].getRates();
    }
}
