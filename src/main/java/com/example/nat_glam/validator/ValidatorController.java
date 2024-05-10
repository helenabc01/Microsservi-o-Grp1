package com.example.nat_glam.validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("validator")
public class ValidatorController {
    private  final ValidatorService validatorService;
    public ValidatorController(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @GetMapping("/validateuser/{cpf}")
    public Boolean Validate(@PathVariable("cpf") String cpf){
        return this.validatorService.isUserTrusted(cpf);
    }

}
