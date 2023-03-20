package com.estockCompany.estockCompanyservice.model;

public class CompanyDtlsModel {

	   private int code;
	   private String name;
	   private String ceo;
	   private long trunover;
	   private String website;
	   private String stockExchangeEnlisted;
	   private float stockPrice;


	   public CompanyDtlsModel(int code, String name, String ceo, Long trunover, String website, String stockExchangeEnlisted, float stockPrice) {
	      this.code = code;
	      this.name = name;
	      this.ceo = ceo;
	      this.trunover = trunover.longValue();
	      this.website = website;
	      this.stockExchangeEnlisted = stockExchangeEnlisted;
	      this.stockPrice = stockPrice;
	   }

	   public CompanyDtlsModel() {}

	   public int getCode() {
	      return this.code;
	   }

	   public void setCode(int code) {
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
	      return Long.valueOf(this.trunover);
	   }

	   public void setTrunover(Long trunover) {
	      this.trunover = trunover.longValue();
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

	   public float getStockPrice() {
	      return this.stockPrice;
	   }

	   public void setStockPrice(float stockPrice) {
	      this.stockPrice = stockPrice;
	   }

	   public String toString() {
	      return "CompanyDtlsModel [code=" + this.code + ", name=" + this.name + ", ceo=" + this.ceo + ", trunover=" + this.trunover + ", website=" + this.website + ", stockExchangeEnlisted=" + this.stockExchangeEnlisted + ", stockPrice=" + this.stockPrice + "]";
   }
}
