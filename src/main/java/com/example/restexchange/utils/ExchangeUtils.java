package com.example.restexchange.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.client.RestClient;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static com.example.restexchange.commons.Commons.*;

public class ExchangeUtils
{
    private static String getUsdCurse()
    {
        RestClient restClient = RestClient.create();

        String result = restClient.get()
                .uri("http://api.nbp.pl/api/exchangerates/rates/c/usd/today/?format=json")
                .retrieve()
                .body(String.class);

        return result;
    }

    public static Map<String, BigDecimal> getUsdValues()
    {
        String jsonString = getUsdCurse();

        Map<String, BigDecimal> resultMap = new HashMap<>();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        if(jsonObject.get(RATES) != null && jsonObject.get(RATES).isJsonArray())
        {
            JsonArray jsonRates = jsonObject.get(RATES).getAsJsonArray();
            JsonObject jsonElements = jsonRates.getAsJsonArray().get(0).getAsJsonObject();

            resultMap.put(BID, jsonElements.get(BID).getAsBigDecimal());
            resultMap.put(ASK, jsonElements.get(ASK).getAsBigDecimal());
        }

        return resultMap;
    }
}
