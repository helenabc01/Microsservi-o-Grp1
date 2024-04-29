package user;

import java.time.LocalDate;
import java.util.InputMismatchException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "clientes")
public class User {

    public User(){}

    private User(String fullName, Long cpf, String email, String cellphone, String address, String password, LocalDate birthdate, Boolean trusted){
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
    private Long cpf;

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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
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
