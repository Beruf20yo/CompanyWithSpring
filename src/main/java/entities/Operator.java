package entities;

import jakarta.persistence.*;
@Entity
public class Operator extends Employee {
    public Operator(Company company) {
        this.employeetype = "Operator";
        monthSalary = 40000;
        incomeForCompany = 0;
        this.company = company;
    }

    public Operator() {

    }
}