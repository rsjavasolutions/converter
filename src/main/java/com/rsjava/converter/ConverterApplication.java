package com.rsjava.converter;
import com.rsjava.converter.service.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);

		CurrencyService currencyService = new CurrencyService();
		System.out.println(currencyService.getValueByCode("EUR"));


	}



}
