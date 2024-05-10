package com.example.nat_glam.user.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "clientes")
public class User {

    public User(){}

    private User(String fullName, String cpf, String email, String cellphone, String address, String password, LocalDate birthdate, Boolean trusted){
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.address = address;
        this.birthdate = birthdate;
        this.trusted = trusted;
    }

    @Column(name = "data_cadastro_cli")
    private LocalDate creationDate;

    @Column(name = "niver_cli")
    private LocalDate birthdate;

    @Column(name = "nome_cli")
    private String fullName;

    @Column(name = "celular_cli")
    private String cellphone;

    @Column(name = "end_res_cli")
    private String address;

    @Column(name = "trusted_cli")
    private Boolean trusted;

    @Id
    @Column(name = "cpf_cli")
    private String cpf;

    @Column(name = "email_cli")
    private String email;

    @Column(name = "senha_cli")
    private String password;



    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "creationDate=" + creationDate +
                ", birthdate=" + birthdate +
                ", fullName='" + fullName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", address='" + address + '\'' +
                ", trusted=" + trusted +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
