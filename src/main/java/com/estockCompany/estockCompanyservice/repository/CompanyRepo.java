package com.estockCompany.estockCompanyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estockCompany.estockCompanyservice.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

   @Query(
      value = "SELECT C.name FROM COMPANY_DTLS C",
      nativeQuery = true
   )
   List getCompanyList();

   @Query(
      value = " select c.code,c.name,c.ceo,c.trunover,c.website,c.se_enlisted,coalesce((SELECT stock_price FROM stock_dtls where company_code=c.code ORDER BY id DESC LIMIT 1) ,0.0)stock_price from company_dtls c where c.code= ?1",
      nativeQuery = true
   )
   List getCompanyDtls(int var1);

   @Query(
      value = " select c.code,c.name,c.ceo,c.trunover,c.website,c.se_enlisted, coalesce((SELECT stock_price FROM stock_dtls where company_code=c.code ORDER BY id DESC LIMIT 1) ,0.0)stock_price from company_dtls c",
      nativeQuery = true
   )
   List getAllCompanys();
}

