package com.mindtree.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
public class Apparal extends Product{
	
	
	private String type;
	private String brand;
	private String design;
	
	
	public Apparal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apparal(int productId, String productName, float price, String category) {
		super(productId, productName, price, category);
		// TODO Auto-generated constructor stub
	}

	public Apparal(int apparalId, String type, String brand, String design) {
		super();
		
		this.type = type;
		this.brand = brand;
		this.design = design;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(brand, design, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apparal other = (Apparal) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(design, other.design)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Apparal [ type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}

	@Override
	public int compareTo(Product that ) {
		// TODO Auto-generated method stub
		return (int) (this.getPrice()-that.getPrice());
	}
	
	
	
	
}