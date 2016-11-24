package be.vdab.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import be.vdab.entities.*;

public class SausDAO {
	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
	
	static {
		SAUZEN.put(1L, new Saus(1, "cocktail", Arrays.asList("Cocktail, test")));
		SAUZEN.put(2L, new Saus(2, "mayonaise", Arrays.asList("Mayonaise, test")));
		SAUZEN.put(3L, new Saus(3, "mosterd", Arrays.asList("Mosterd, test")));
		SAUZEN.put(4L, new Saus(4, "tartare", Arrays.asList("Tartare")));
		SAUZEN.put(5L, new Saus(5, "vinaigrette", Arrays.asList("Vinaigrette, test")));
	}
	
	public List<Saus> findAll(){
		return SAUZEN.values().stream().collect(Collectors.toList());
	}
}
