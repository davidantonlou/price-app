package com.example.priceapp.repository;

import com.example.priceapp.utils.Constants;
import com.example.priceapp.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@DataJpaTest
public class PriceRepositoryTest {

    @Autowired
    PriceRepository priceRepository;

    @Test
    public void testGetPriceByDateAndProductId() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        Long productId = Long.valueOf(35455);
        Long brandId = Long.valueOf(1);

        // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        Date date = dateFormat.parse("14/06/2020 10:00");
        List<Price> prices = priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId);
        assertNotNull(prices);

        // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        date = dateFormat.parse("14/06/2020 16:00");
        prices = priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId);
        assertNotNull(prices);

        // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        date = dateFormat.parse("14/06/2020 21:00");
        prices = priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId);
        assertNotNull(prices);

        // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        date = dateFormat.parse("15/06/2020 10:00");
        prices = priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId);
        assertNotNull(prices);

        // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        date = dateFormat.parse("16/06/2020 21:00");
        prices = priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId);
        assertNotNull(prices);

    }
}