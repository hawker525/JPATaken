package be.vdab.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService extends AbstractService{
	private final ArtikelRepository artikelRepository = new ArtikelRepository();

	public Optional<Artikel> read(long id){
		return artikelRepository.read(id);
	}

	public void create(Artikel artikel) {
		beginTransaction();
		try {
			artikelRepository.create(artikel);
			commit();
		} catch (RuntimeException e) {
			rollback();
			throw e;
		}
	}
	
	public List<Artikel> findArtikelByNaam(String naam){
		return artikelRepository.findArtikelByNaam(naam);
	}
	
}
