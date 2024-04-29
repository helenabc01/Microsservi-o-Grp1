package com.example.nat_glam.validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("validator")
public class ValidatorController {
    public ValidatorController() {
    }

    @GetMapping("/validateuser/{cpf}")
    public Boolean Validate(@PathVariable("cpf")Long cpf){

    }

}
