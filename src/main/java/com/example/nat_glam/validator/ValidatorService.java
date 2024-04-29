package com.example.nat_glam.validator;

import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
@Service
public class ValidatorService {

    public static boolean isValidCPF(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
            }

            int digit1 = 11 - (sum % 11);
            if (digit1 > 9) digit1 = 0;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
            }
            int digit2 = 11 - (sum % 11);
            if (digit2 > 9) digit2 = 0;

            return Integer.parseInt(cpf.substring(9, 10)) == digit1 && Integer.parseInt(cpf.substring(10, 11)) == digit2;

        } catch (InputMismatchException e){
            return false;
        }

    }
}
