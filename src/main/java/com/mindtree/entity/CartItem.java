package com.mindtree.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer cartIteamId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cart_id",referencedColumnName = "cartId")
	@JsonBackReference
    private MyCart cart;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="product_id",referencedColumnName = "productId")
	private Product product;
	
	private int quantity;
	
	@Transient
	private float subPrice;

	public Integer getCartIteamId() {
		return cartIteamId;
	}

	public void setCartIteamId(Integer cartIteamId) {
		this.cartIteamId = cartIteamId;
	}

	public MyCart getCart() {
		return cart;
	}

	public void setCart(MyCart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(float subPrice) {
		this.subPrice = subPrice;
	}
	
     
	@Override
	public int hashCode() {
		return Objects.hash(cart, cartIteamId, product, quantity, subPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(cartIteamId, other.cartIteamId)
				&& Objects.equals(product, other.product) && quantity == other.quantity
				&& Float.floatToIntBits(subPrice) == Float.floatToIntBits(other.subPrice);
	}

	@Override
	public String toString() {
		return "CartItem [cartIteamId=" + cartIteamId + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + ", subPrice=" + subPrice + "]";
	}
	
	
	
	
	
}
