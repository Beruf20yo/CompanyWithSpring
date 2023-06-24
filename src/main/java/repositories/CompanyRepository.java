package repositories;

import entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    @Query("SELECT com.incomeCompany FROM Company com WHERE com.idCompany =:id")
    int findAllByIdCompanyIs(@Param("id") int idCompany);
    @Query("SELECT Company FROM Company com WHERE com.idCompany =:id")
    Company findByIdCompany(int idCompany);

}
