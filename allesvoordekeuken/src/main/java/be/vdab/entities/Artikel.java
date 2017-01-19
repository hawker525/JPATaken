package be.vdab.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import be.vdab.valueobjects.Korting;

/**
 * Created by Maarten Westelinck on 22/12/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "soort")
@Table(name = "artikels")
public abstract class Artikel implements Serializable{
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;
    @ElementCollection
    @CollectionTable(name = "kortingen", joinColumns = @JoinColumn(name = "artikelid"))
    @OrderBy("vanafAantal")
    private Set<Korting> kortingen;

    public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
    	setNaam(naam);
    	setAankoopprijs(aankoopprijs);
    	setVerkoopprijs(verkoopprijs);
    	this.kortingen = new HashSet<>();
    }
    
    public Set<Korting> getKortingen(){
    	return Collections.unmodifiableSet(kortingen);
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
