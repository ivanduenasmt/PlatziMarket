package com.platzimarket.web.controller;

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }

    @GetMapping("/client/{clientId}")
    public Optional<List<Purchase>> getByClient(@PathVariable("clientId") String clientId){
        return purchaseService.getByClient(clientId);
    }

    @PostMapping("/save")
    public Purchase save(@RequestBody Purchase purchase){
        return purchaseService.save(purchase);
    }
}
