package be.vdab.repositories;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Maarten Westelinck on 22/12/2016 for AllesVoorDeKeuken.
 */
public class ArtikelRepository extends AbstractRepository{

    public Optional<Artikel> read(long id) {
		return Optional.ofNullable(getEntityManager().find(Artikel.class, id));
    }

    
    public void create(Artikel artikel) {
    	getEntityManager().persist(artikel);
    }
    
    public List<Artikel> findArtikelByNaam(String naam){
    	return getEntityManager()
    			.createQuery("select a from Artikel a where a.naam like :query order by a.naam", Artikel.class)
    			.setParameter("query", "%"+naam+"%")
    			.getResultList();
    }
    
    public void verkoopprijsVerhoging(BigDecimal factor) {
    	getEntityManager().createQuery("update Artikel a set a.verkoopprijs = a.verkoopprijs * :factor")
    		.setParameter("factor", factor)
    		.executeUpdate();
    }
    
    public List<Artikel> findAll(){
    	return getEntityManager().createQuery("select a from Artikel a order by a.naam", Artikel.class)
    			.getResultList();
    }
    
}
