package com.example.priceapp.repository;

import com.example.priceapp.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandId(Date startDate, Date endDate, Long productId, Long brandId);
}