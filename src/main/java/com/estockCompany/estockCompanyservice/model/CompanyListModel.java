package com.estockCompany.estockCompanyservice.model;

public class CompanyListModel {
	 private Long code;
	   private String name;


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

	   public String toString() {
	      return "CompanyListModel [code=" + this.code + ", name=" + this.name + "]";
	   }
}
