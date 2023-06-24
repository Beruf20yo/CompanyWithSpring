package controllers;
import entities.Company;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.CompanyService;
import services.EmployeeService;
import java.util.List;

@Controller
@Setter
@RequestMapping("/company")
public class MainController {
    private CompanyService companyService;
    private EmployeeService employeeService;


    @GetMapping("/{id}/income")
    public int getIncomeCompany(@PathVariable Integer idCompany){
        return companyService.getIncomeCompany(idCompany);
    }
    @PostMapping("/add")
    public boolean addCompany(@ModelAttribute(value="company") Company company){
        companyService.saveCompany(company);
        return true;
    }
    @GetMapping
    public List<Company> showCompanies(){
        return companyService.getAllCompanies();
    }
    @PostMapping("/{id}/work_with_employee/delete/{idEmployee}")
    public boolean deleteEmployee(@PathVariable Integer idCompany, @PathVariable Integer idEmployee){
        return employeeService.deleteEmployee(idEmployee, companyService.getCompany(idCompany));
    }
    @PostMapping("/{id}/work_with_employee/delete/{count}")
    public boolean deleteSomeEmployee(@PathVariable Integer idCompany, @PathVariable Integer count){
        return employeeService.deleteSomeEmployee(companyService.getCompany(idCompany), count);
    }

    @PostMapping("/{id}/work_with_employee/add/{typeEmployee}/{count}")
    public boolean addEmployee(@PathVariable Integer idCompany, @PathVariable Integer typeEmployee, @PathVariable Integer count){
        return employeeService.newEmployee(typeEmployee,count,companyService.getCompany(idCompany));
    }
    @GetMapping("/{id}/work_with_employee/{typeSalaryStaff}/{count}")
    public List<Integer> getSalaryStaff(@PathVariable Integer idCompany, @PathVariable String typeSalaryStaff, @PathVariable Integer count){
        return employeeService.getSalaryStaffByCompany(typeSalaryStaff,companyService.getCompany(idCompany), count);
    }
}
