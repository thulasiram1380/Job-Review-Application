package com.example.company.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        return new ResponseEntity<>(companyService.findAllCompany(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.findCompanyById(id);
        if(company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company,
                                        @PathVariable Long id) {
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean deleted = companyService.deleteCompanyById(id);

        if(deleted){
            return new ResponseEntity<>("Successfully Deleted" , HttpStatus.OK);
        }else
            return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }
}
