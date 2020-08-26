package com.myretail.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "price")
@Data
public class CurrentPrice {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private Float value;
    private String currencyCode;

    public CurrentPrice() {
    }

    public CurrentPrice(Long id, Float value, String currencyCode) {
        this.id = id;
        this.value = value;
        this.currencyCode = currencyCode;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
    
    
}
