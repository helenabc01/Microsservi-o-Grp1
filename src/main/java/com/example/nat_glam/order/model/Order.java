package com.example.nat_glam.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "pedidos")
public class Order {

    public Order(){}


    public Order(String trackingPed, String addressPed, String transpPed, Float value, Boolean noPay, String cliCpf, Integer carIdPed) {
        this.trackingPed = trackingPed;
        this.addressPed = addressPed;
        this.transpPed = transpPed;
        this.value = value;
        this.noPay = noPay;
        this.cliCpf = cliCpf;
        this.carIdPed = carIdPed;
    }

    @Column(name = "data_ped")
    private LocalDate creationDate;

    @Column(name = "rastreio_ped")
    private String trackingPed;

    @Column(name = "end_entrega_ped")
    private String addressPed;

    @Column(name = "transp_ped")
    private String transpPed;

    @Column(name = "valor_ped")
    private Float value ;

    @Column(name= "ped_sem_pgto")
    private Boolean noPay;

    @Id
    @Column(name = "id_ped")
    private Integer id;

    @Column(name = "CPF_cli_ped")
    private String cliCpf;

    @Column(name = "id_car_ped")
    private Integer carIdPed;

}
