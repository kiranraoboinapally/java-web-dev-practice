package com.example.Controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Model.Currency;
import com.example.Repository.CurrencyRepo;
import com.example.Service.CurrencyService;

@Controller
public class CurrencyConverter {
	@Autowired
	private CurrencyService currencyService;
	@Autowired
	private CurrencyRepo currencyRepo;
	@GetMapping("/")
	public String showForm(Model model) {
		Map<String,Object> rates=currencyService.getRates();
		model.addAttribute("currencies",rates.keySet());
		model.addAttribute("history",currencyRepo.findAll());
		return "index";
	}
    @PostMapping("/convert")
    public String convert(@RequestParam double usdAmount,
                          @RequestParam String targetCurrency,
                          Model model) {
        double converted = currencyService.convert(usdAmount, targetCurrency);
        Currency currency = new Currency();
        currency.setUsdAmount(usdAmount);
        currency.setTargetCurrency(targetCurrency);
        currency.setConvertedAmount(converted);
        currency.setTimestamp(LocalDateTime.now());
        currencyRepo.save(currency);
        return "redirect:/";
    }
}
