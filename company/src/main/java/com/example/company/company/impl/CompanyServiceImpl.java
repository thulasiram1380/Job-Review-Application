package com.example.company.company.impl;


import com.example.company.company.Company;
import com.example.company.company.CompanyRepo;
import com.example.company.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepo.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> updateCompany = companyRepo.findById(id);
        if(updateCompany.isPresent()){
            Company update = updateCompany.get();
            update.setName(company.getName());
            update.setDescription(company.getDescription());
            companyRepo.save(update);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if(companyRepo.existsById(id)) {
            companyRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }
}
