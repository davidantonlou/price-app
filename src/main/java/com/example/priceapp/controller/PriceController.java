package com.example.priceapp.controller;

import com.example.priceapp.model.Price;
import com.example.priceapp.service.PriceService;
import com.example.priceapp.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Api(tags = "Prices")
@RestController
@RequestMapping("/api/v1/")
public class PriceController {

    @Autowired
    private PriceService priceService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);

    @ApiOperation(nickname = "prices", value = "Get all prices", response = List.class)
    @GetMapping(path = "prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPrices() {
        return new ResponseEntity(priceService.getAllPrices(), HttpStatus.OK);
    }

    @ApiOperation(nickname = "price", value = "Get price by productId, brandId and date", response = Price.class)
    @GetMapping(path = "price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPrice(@RequestParam String inputDate, @RequestParam Long productId, @RequestParam Long brandId) {
        try {
            return new ResponseEntity(priceService.getPrice(dateFormat.parse(inputDate), productId, brandId), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity(Constants.DATE_ERROR_FORMAT, HttpStatus.BAD_REQUEST);
        }
    }
}