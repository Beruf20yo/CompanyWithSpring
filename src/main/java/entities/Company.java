package entities;



import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int idCompany;
    @Column(name = "name_company")
    protected String nameCompany;
    @Column(name = "income_company")
    protected int incomeCompany;
    @OneToMany(mappedBy = "company")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Employee> employees;

    public Company() {

    }
    public Company(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void hire(Employee employee) {

    }

    public void hireAll(List<Employee> lisdToAdd) {
        for (Employee employee : lisdToAdd) {
            hire(employee);
        }
    }

    public void fire(int id) {
        try {

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы ввели неверное чилсо");
        }
    }

    public void fire() {

    }

    public int getIncomeCompany() {
        return 0;
    }

    public void setIncomeCompany(int incomeCompany) {
        this.incomeCompany += incomeCompany;
    }

    @Override
    public String toString() {
        return idCompany + ". " + nameCompany;
    }
}
