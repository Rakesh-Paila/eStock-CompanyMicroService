package com.estockCompany.estockCompanyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockCompany.estockCompanyservice.entity.Company;
import com.estockCompany.estockCompanyservice.exception.CompanyRegisterException;
import com.estockCompany.estockCompanyservice.model.CompanyDtlsModel;
import com.estockCompany.estockCompanyservice.service.CompanyService;

@RestController
@RequestMapping(
   produces = {"application/json"}
)
@CrossOrigin(
   origins = {"*"}
)
public class CompanyController {

   @Autowired
   CompanyService companyService;


   @PostMapping({"/register"})
   public ResponseEntity addCompany(@RequestBody Company c) throws CompanyRegisterException {
      return new ResponseEntity(Long.valueOf(this.companyService.addCompany(c)), HttpStatus.CREATED);
   }

   @GetMapping({"/info/{companyCode}"})
   public CompanyDtlsModel getCompany(@PathVariable int companyCode) {
      CompanyDtlsModel company = this.companyService.getCompanyDtls(companyCode);
      return company;
   }

   @GetMapping({"/getAll"})
   public List getAllCompany() {
      return this.companyService.getAllCompanys();
   }

   @DeleteMapping({"/delete/{companyCode}"})
   public void deleteCompany(@PathVariable int companyCode) {
      this.companyService.deleteCompany(companyCode);
   }

   @GetMapping({"/companyList"})
   public List getCompanyList() {
      return this.companyService.getCompanyList();
   }
}
