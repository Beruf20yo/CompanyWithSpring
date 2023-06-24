package entities;

import jakarta.persistence.*;
@Entity
public class Manager extends Employee {
    public Manager(Company company) {
        this.employeetype = "Manager";
        this.company = company;
        this.incomeForCompany = setCompanyIncome();
        int ratePerMounth = 60000;
        this.monthSalary = (setCompanyIncome() * 5 / 100) + ratePerMounth;
    }
    public Manager() {
    }
    public int setCompanyIncome() {
        int startRange = 115000;
        int endRange = 140000;
        int incomePart = startRange + (int) (Math.random() * endRange);
        return incomePart;
    }
}