package com.mindtree.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MyCart {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
     @OneToOne(cascade =CascadeType.PERSIST)
     private User user;
    
     @OneToMany(mappedBy = "cart")
    @JsonManagedReference
     private List<CartItem> cartIteam;
     
     @Transient
     private float totalPrice;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartIteam() {
		return cartIteam;
	}

	public void setCartIteam(List<CartItem> cartIteam) {
		this.cartIteam = cartIteam;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(cartId, cartIteam, totalPrice, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyCart other = (MyCart) obj;
		return cartId == other.cartId && Objects.equals(cartIteam, other.cartIteam)
				&& Float.floatToIntBits(totalPrice) == Float.floatToIntBits(other.totalPrice)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "MyCart [cartId=" + cartId + ", user=" + user + ", cartIteam=" + cartIteam + ", totalPrice=" + totalPrice
				+ "]";
	}
   
     
     
	
}
