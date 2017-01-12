package be.vdab.repositories;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 22/12/2016 for AllesVoorDeKeuken.
 */
public class ArtikelRepository {

    public Optional<Artikel> find(long id) {
        EntityManager entityManager = JPAFilter.getEntityManager();
        try{
            return Optional.ofNullable(entityManager.find(Artikel.class, id));
        } finally {
            entityManager.close();
        }
    }

}
