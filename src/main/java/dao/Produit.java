package dao;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "PRODUITS")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REF")
	private Long reference;
	@Column (name="DES")
	private String designation;
	private double prix;
	private int quantite;
	public Produit(String designation , double prix , int quantite) {
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {}
	//Getters & Setters
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
