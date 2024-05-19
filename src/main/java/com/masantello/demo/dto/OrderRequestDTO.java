package com.masantello.demo.dto;

public class OrderRequestDTO {

	private String buyerEmail;
	
	public OrderRequestDTO() {
		super();
	}

	public OrderRequestDTO(String buyerEmail) {
		super();
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

}
