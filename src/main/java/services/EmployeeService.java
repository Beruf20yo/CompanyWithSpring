package services;

import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EmployeeRepository;

import java.util.*;



@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Удаление Employee по id
    public boolean deleteEmployee(int idEmployee, Company company2){
        Company company1 = employeeRepository.findByIdEmployee(idEmployee); //Поиск компании по сотруднику
        if(company1.equals(company2)){ // Является ли компания, которой принадлежит Employee,
            // той же самой компанией, что была передана в метод
            employeeRepository.deleteById(idEmployee);
            return true;
        }
        return false;
    }
    public boolean deleteSomeEmployee(Company company, int count){
        while (count != 0){
            employeeRepository.deleteEmployeeByCompany(company);
            count--;
        }
        return true;
    }
    //Сохранение добавленного
    public boolean newEmployee(int typeEmployee, int count, Company company){
        while (count != 0) {
            Employee employee = addOneEmployee(typeEmployee, company);
            if (employee == null) {
                return false;
            } else {
                employeeRepository.save(employee);
                count--;
            }
        }
        return true;
    }
    public Employee addOneEmployee(int  typeEmployee, Company company) {
        return switch (typeEmployee) {
            case 1 -> new Manager(company);
            case 2 -> new TopManager(company);
            case 3 -> new Operator(company);
            default -> throw new IllegalStateException("Unexpected value: " + typeEmployee);
        };
    }


    //Информация о зарплатах
     public List<Integer> getSalaryStaffByCompany(String setTopOrLow, Company company, int count){
         TreeSet<Integer> SalaryTree = null;
         switch (setTopOrLow){
             case "Top" -> SalaryTree = new TreeSet<>((o1, o2) -> o2 - o1);
             case "Low" -> SalaryTree = new TreeSet<>(Comparator.comparingInt(o -> o));
         }
         List<Integer> SalaryList = new ArrayList<>();
         SalaryTree.addAll(employeeRepository.findAllByCompany(company));
         Iterator<Integer> it = SalaryTree.iterator();
         try {
             if (count > SalaryTree.size() - 1 || count < 0) {
                 throw new IllegalStateException();
             }
             while (count != 0) {
                 SalaryList.add(it.next());
                 count--;
             }
         } catch (IllegalStateException e) {
             System.out.println("Вы ввели неверное кол-во зарплат, всего уникальных зарплат = " + SalaryTree.size());
         }
         return SalaryList;
     }


}
