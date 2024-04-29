package com.example.nat_glam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import user.User;

import java.util.Scanner;

@EnableKafka
@SpringBootApplication
public class NatGlamApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF:");
        String cpf = scanner.nextLine();

        if (User.isValidCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");

            if (cpf.length() != 11) {
                System.out.println("O CPF deve ter 11 dígitos.");
            } else if (cpf.matches("(\\d)\\1{10}")) {
                System.out.println("Todos os dígitos do CPF são iguais.");
            } else {
                System.out.println("O CPF falhou no teste de verificação.");
            }
        }
        scanner.close();
    }

}
