package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    int idEmployee;
    @ManyToOne
    @JoinColumn(name = "id_company")
    Company company;
    @Column(name = "month_salary")
    int monthSalary;
    @Column(name = "income_for_company")
    int incomeForCompany;
    @Column(name = "type_employee")
    String employeetype;


}
