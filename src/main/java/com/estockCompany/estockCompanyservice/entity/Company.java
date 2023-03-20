package com.estockCompany.estockCompanyservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(
	name = "COMPANY_DTLS"
)
public class Company {

   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long code;
   @Column(
      name = "name",
      unique = true,
      nullable = false
   )
   private String name;
   @Column(
      name = "ceo",
      unique = true,
      nullable = false
   )
   private String ceo;
   @Column(
      name = "trunover",
      nullable = false
   )
   private Long trunover;
   @Column(
      name = "website",
      nullable = false
   )
   private String website;
   @Column(
      name = "se_enlisted",
      nullable = false
   )
   private String stockExchangeEnlisted;


   public Long getCode() {
      return this.code;
   }

   public void setCode(Long code) {
      this.code = code;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCeo() {
      return this.ceo;
   }

   public void setCeo(String ceo) {
      this.ceo = ceo;
   }

   public Long getTrunover() {
      return this.trunover;
   }

   public void setTrunover(Long trunover) {
      this.trunover = trunover;
   }

   public String getWebsite() {
      return this.website;
   }

   public void setWebsite(String website) {
      this.website = website;
   }

   public String getStockExchangeEnlisted() {
      return this.stockExchangeEnlisted;
   }

   public void setStockExchangeEnlisted(String stockExchangeEnlisted) {
      this.stockExchangeEnlisted = stockExchangeEnlisted;
   }

   public String toString() {
      return "Company [code=" + this.code + ", name=" + this.name + ", ceo=" + this.ceo + ", trunover=" + this.trunover + ", website=" + this.website + ", stockExchangeEnlisted=" + this.stockExchangeEnlisted + "]";
   }
}
