package com.example.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency_converter")  
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getUsdAmount() {
		return usdAmount;
	}
	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public Double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	private Double usdAmount;
	private String targetCurrency;
	private Double convertedAmount;
	private LocalDateTime timestamp;
}
