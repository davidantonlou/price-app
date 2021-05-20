package com.example.priceapp.service;

import com.example.priceapp.model.Price;
import com.example.priceapp.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll().stream()
                .sorted(Comparator.comparing(Price::getPriority).reversed()).collect(Collectors.toList());
    }

    public Price getPrice(Date date, Long productId, Long brandId) {
        return priceRepository.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(date, date, productId, brandId).
                stream().sorted(Comparator.comparing(Price::getPriority).reversed()).findFirst().get();
    }
}
