package com.example.nat_glam.validator;
import com.example.nat_glam.order.repository.OrderRepository;
import com.example.nat_glam.user.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nat_glam.user.repository.UserRepository;
import java.util.InputMismatchException;

@Service
@Transactional
public class ValidatorService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired()
    ValidatorService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    private boolean isValidCPF(String cpf){
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

    private boolean findOrdersWithNoPayments(String cpf) {
        Long query = this.orderRepository.countUnpaidOrdersByCpf(cpf);
        return query > 0;
    }

    private boolean  verifyClientIsTrust(String cpf) {
        Boolean user = this.userRepository.findTrustedByCpf(cpf);
        if (user == null) return false;
        return user;
    }

    protected boolean isUserTrusted(String cpf) {
        String userExist = userRepository.findUserByCpf(cpf);
        if (userExist == null) return false;

        if(isValidCPF(cpf) && !findOrdersWithNoPayments(cpf) && verifyClientIsTrust(cpf)){
            return true;
        }

        userRepository.updateByCpf(cpf,false);
        return false;

    }
}
