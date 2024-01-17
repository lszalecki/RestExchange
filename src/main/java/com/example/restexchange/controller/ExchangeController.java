package com.example.restexchange.controller;

import com.example.restexchange.utils.ExchangeUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static com.example.restexchange.commons.Commons.*;

@RestController()
@RequestMapping("/exchange")
@AllArgsConstructor
public class ExchangeController
{
    @GetMapping("/plnusd/{pln}")
    public Map<String, BigDecimal> getPlnToUsd(@PathVariable BigDecimal pln) throws NumberFormatException
    {
        Map<String, BigDecimal> usdValues = ExchangeUtils.getUsdValues();

        Map<String, BigDecimal> resultMap = new HashMap<>();
        resultMap.put(BID_USD, pln.divide(usdValues.get(BID), MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING));
        resultMap.put(ASK_USD, pln.divide(usdValues.get(ASK), MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING));

        return resultMap;
    }

    @GetMapping("/usdpln/{pln}")
    public Map<String, BigDecimal> getUsdToPln(@PathVariable BigDecimal pln) throws NumberFormatException
    {
        Map<String, BigDecimal> usdValues = ExchangeUtils.getUsdValues();

        Map<String, BigDecimal> resultMap = new HashMap<>();
        resultMap.put(BID_PLN, pln.multiply(usdValues.get(BID), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_EVEN));
        resultMap.put(ASK_PLN, pln.multiply(usdValues.get(ASK), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_EVEN));

        return resultMap;
    }
}
