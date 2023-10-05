package com.example.EmailPrototype.Controller;

import com.example.EmailPrototype.DTO.EmailPrototypeDto;
import com.example.EmailPrototype.Service.EmailSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1")
@RestController
public class EmailPrototypeController {
    @Autowired
    EmailSevice emailSevice;

    @PostMapping("/generateOtp")
    public ResponseEntity<String> register(@RequestBody EmailPrototypeDto emailPrototypeDto) {
        return new ResponseEntity<>(emailSevice.register( emailPrototypeDto), HttpStatus.OK);
    }
}


