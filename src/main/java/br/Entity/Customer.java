package br.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    private long idCustomer;

    @Column(name="first_name_customer", nullable=false, length=300)
    private String firtNameCustomer;
    @Column(name="last_name_customer",nullable=false, length=300)
    private String lastNameCustomer;
    @Column(name="cpf_customer", nullable=false, length=11)
    private String cpfCustomer;
    @Column(name="birthdate_customer", nullable=false)
    private LocalDate birthDateCustomer;
    @Column(name="date_created_customer", nullable =false, updatable=false)
    private LocalDate dateCreatedCustomer;
    @Column(name="monthtly_income_customer", nullable=false, precision=10, scale=2)
    private BigDecimal monthtlyIncomeCustomer;
    @Column(name="status_customer", nullable=false)
    private Boolean statusCustomer;
    @Column(name="email_customer", nullable=false, unique=true, length=300)
    private String emailCustomer;
    @Column(name="password_customer", nullable=false )
    private String passwordCustomer;

    @PrePersist
    private void prePersist(){
        this.setDateCreatedCustomer(LocalDate.now());
        this.setStatusCustomer(true);
    }
}