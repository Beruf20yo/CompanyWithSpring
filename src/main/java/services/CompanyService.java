package services;

import entities.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public boolean saveCompany(Company company){
        companyRepository.save(company);
        return true;
    }
    public int getIncomeCompany(int idCompany){
        return companyRepository.findAllByIdCompanyIs(idCompany);
    }
    public Company getCompany(int idCompany){
        return companyRepository.findByIdCompany(idCompany);
    }


}
