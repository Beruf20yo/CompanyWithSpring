package entities;

import jakarta.persistence.*;

@Entity
public class TopManager extends Employee {
    protected int ratePerMounth = 80000;

    public TopManager(Company company) {
        this.employeetype = "TopManager";
        this.company = company;
        incomeForCompany = 0;
        if (company.getIncomeCompany() > 10000000) {
            this.monthSalary = ratePerMounth * 5 / 2;
        } else {
            this.monthSalary = ratePerMounth;
        }
    }

    public TopManager() {

    }

    public int getMonthSalary() {
        if (company.getIncomeCompany() > 10000000) {
            this.monthSalary = ratePerMounth * 5 / 2;
        }
        return monthSalary;
    }
}