package com.estockCompany.estockCompanyservice.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estockCompany.estockCompanyservice.entity.Company;
import com.estockCompany.estockCompanyservice.exception.CompanyRegisterException;
import com.estockCompany.estockCompanyservice.model.CompanyDtlsModel;
import com.estockCompany.estockCompanyservice.model.CompanyListModel;
import com.estockCompany.estockCompanyservice.repository.CompanyRepo;

@Service
public class CompanyService {

   @Value("${stockService.url}")
   private String stockServicrUrl;
   @Autowired
   CompanyRepo companyRepo;
   @Autowired
   private RestTemplate restTemplate;


   public Long addCompany(Company c) throws CompanyRegisterException {
      if(c.getTrunover().longValue() >= 1000000L) {
         Company comp = (Company)this.companyRepo.save(c);
         return comp.getCode();
      } else {
         throw new CompanyRegisterException("Company turnover must be greater than 10Cr");
      }
   }

   public void deleteCompany(int companyCode) {
      try {
         this.restTemplate.delete(this.stockServicrUrl + "/deleteStocks/" + companyCode, new Object[0]);
         this.companyRepo.deleteById(Long.valueOf(companyCode));
      } catch (Exception var3) {
         System.out.println("Exception in deleteCompany :" + var3);
      }

   }

   public CompanyDtlsModel getCompanyDtls(int companyCode) {
      CompanyDtlsModel comp = new CompanyDtlsModel();
      List listObj = this.companyRepo.getCompanyDtls(companyCode);
      Iterator var5 = listObj.iterator();
      if(var5.hasNext()) {
         Object[] rs = (Object[])var5.next();
         int code = ((BigInteger)rs[0]).intValue();
         String name = (String)rs[1];
         String ceo = (String)rs[2];
         BigInteger trunover = (BigInteger)rs[3];
         String website = (String)rs[4];
         String stockExchangeEnlisted = (String)rs[5];
         Double stockPrice = (Double)rs[6];
         comp.setCode(code);
         comp.setName(name);
         comp.setCeo(ceo);
         comp.setTrunover(Long.valueOf(trunover.longValue()));
         comp.setWebsite(website);
         comp.setStockExchangeEnlisted(stockExchangeEnlisted);
         comp.setStockPrice(stockPrice.floatValue());
      }

      return comp;
   }

   public List getAllCompanys() {
      ArrayList compList = new ArrayList();
      List listObj = this.companyRepo.getAllCompanys();
      Iterator var4 = listObj.iterator();

      while(var4.hasNext()) {
         Object[] rs = (Object[])var4.next();
         CompanyDtlsModel comp = new CompanyDtlsModel();
         int code = ((BigInteger)rs[0]).intValue();
         String name = (String)rs[1];
         String ceo = (String)rs[2];
         BigInteger trunover = (BigInteger)rs[3];
         String website = (String)rs[4];
         String stockExchangeEnlisted = (String)rs[5];
         Double stockPrice = (Double)rs[6];
         comp.setCode(code);
         comp.setName(name);
         comp.setCeo(ceo);
         comp.setTrunover(Long.valueOf(trunover.longValue()));
         comp.setWebsite(website);
         comp.setStockExchangeEnlisted(stockExchangeEnlisted);
         comp.setStockPrice(stockPrice.floatValue());
         compList.add(comp);
      }

      return compList;
   }

   public List getCompanyList() {
      ArrayList companyLov = new ArrayList();
      List companyDtls = this.companyRepo.findAll();
      Iterator var4 = companyDtls.iterator();

      while(var4.hasNext()) {
         Company c = (Company)var4.next();
         CompanyListModel clm = new CompanyListModel();
         clm.setCode(c.getCode());
         clm.setName(c.getName());
         companyLov.add(clm);
      }

      return companyLov;
   }
}