package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Maarten Westelinck on 22/12/2016.
 */
@Entity
@Table(name = "artikels")
public class Artikel implements Serializable{
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;

    public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
    	setNaam(naam);
    	setAankoopprijs(aankoopprijs);
    	setVerkoopprijs(verkoopprijs);
    }
    
    public static boolean isNaamValid(String naam) {
    	return naam != null && !naam.isEmpty();
    }
    
    public static boolean isAankoopprijsValid(BigDecimal aankoopprijs) {
    	return aankoopprijs.compareTo(BigDecimal.valueOf(0.01)) == 1;
    }
    
    public static boolean isVerkoopprijsValid(BigDecimal verkoopprijs,  BigDecimal aankoopprijs) {
    	return verkoopprijs.compareTo(aankoopprijs) >= 0;
    }
    
    protected Artikel() {}
    
    public void setNaam(String naam) {
    	if(!isNaamValid(naam)) throw new IllegalArgumentException();
    	this.naam = naam;
    }
    
    public void setAankoopprijs(BigDecimal aankoopprijs) {
    	if(!isAankoopprijsValid(aankoopprijs)) throw new IllegalArgumentException();
    	this.aankoopprijs = aankoopprijs;
    }
   
    public void setVerkoopprijs(BigDecimal verkoopprijs) {
    	if(!isVerkoopprijsValid(verkoopprijs, this.aankoopprijs)) throw new IllegalArgumentException();
    	this.verkoopprijs = verkoopprijs;
    }
    
    public long getId() {
        return id;
    }


    public String getNaam() {
        return naam;
    }

    public BigDecimal getAankoopprijs() {
        return aankoopprijs;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }


}
