package com.abinash.Firstjobapp.JOB.Company.impl;
import com.abinash.Firstjobapp.JOB.Company.Company;
import com.abinash.Firstjobapp.JOB.Company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

// this is the service layer
@Service
public class CompanyServiceimpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void updateCompany(Company company, Long id) {

        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){

            companyOptional.get().setName(company.getName());
            companyOptional.get().setDescription(company.getDescription());

            companyRepository.save(companyOptional.get());
//
//            Company companyToUpdate;
//            companyToUpdate = companyOptional.get();

//            company.setDescription(companyToUpdate.getDescription());
//            companyToUpdate.setJobs(company.getJobs());
//            companyToUpdate.setName(company.getName());
//
//            companyRepository.save(companyToUpdate);
        }else {

        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }


    @Override
    public boolean deleteCompanyById(Long id) {
        if (companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);

    }
}
