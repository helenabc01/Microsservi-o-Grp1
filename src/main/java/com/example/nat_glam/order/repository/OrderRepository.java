package com.example.nat_glam.order.repository;

import com.example.nat_glam.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT COUNT(p) FROM pedidos p WHERE p.cliCpf = :cpfO AND p.noPay = true")
    Long countUnpaidOrdersByCpf(@Param("cpfO") String cpf);

}
