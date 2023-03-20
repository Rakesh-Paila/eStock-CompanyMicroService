package com.estockCompany.estockCompanyservice.model;

import java.util.Map;

public class GatewayResponse {


	   private String body;
	   private Integer statusCode;
	   private Map headers;
	   private boolean isBase64Encoded;


	   public GatewayResponse(String body, Integer statusCode, Map headers, boolean isBase64Encoded) {
	      this.body = body;
	      this.statusCode = statusCode;
	      this.headers = headers;
	      this.isBase64Encoded = isBase64Encoded;
	   }

	   public String getBody() {
	      return this.body;
	   }

	   public void setBody(String body) {
	      this.body = body;
	   }

	   public Integer getStatusCode() {
	      return this.statusCode;
	   }

	   public void setStatusCode(Integer statusCode) {
	      this.statusCode = statusCode;
	   }

	   public Map getHeaders() {
	      return this.headers;
	   }

	   public void setHeaders(Map headers) {
	      this.headers = headers;
	   }

	   public boolean isBase64Encoded() {
	      return this.isBase64Encoded;
	   }

	   public void setBase64Encoded(boolean base64Encoded) {
	      this.isBase64Encoded = base64Encoded;
	   }
}
