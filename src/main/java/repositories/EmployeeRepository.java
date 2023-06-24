package repositories;

import entities.Company;
import entities.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e.monthSalary FROM Employee e where e.company =:company")
    List<Integer> findAllByCompany(@Param("company") Company company);
    @Query(value = "SELECT Company FROM Employee e where e.idEmployee =:id")
    Company findByIdEmployee(@Param("company") int idEmployee);

    Boolean deleteEmployeeByCompany(Company company);
}
