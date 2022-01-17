package com.codegym.controller;

import com.codegym.model.TotalMoney;
import com.codegym.service.ITotalMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RequestMapping("api/public/total")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class TotalMoneyController {
    @Autowired
    ITotalMoneyService iTotalMoneyService;
    @GetMapping("")
    public ResponseEntity<?> getTotal(){
      return new ResponseEntity<>(iTotalMoneyService.getTotalMoney(), HttpStatus.OK);
    };
    @GetMapping("save/{totalMoney}")
    public ResponseEntity<?> saveTotal(@PathVariable Long totalMoney){
        TotalMoney newTotalMoney = new TotalMoney();
        newTotalMoney.setTotalMoney(totalMoney);
        iTotalMoneyService.saveMoney(newTotalMoney);
        return new ResponseEntity<>(HttpStatus.OK);
    };
}
