package com.codingdojo.dojoninja.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.repositories.DojoRepo;
import com.codingdojo.dojoninja.repositories.NinjaRepo;

@Service
public class MainService {
	
	private final NinjaRepo ninjaRepo;
	private final DojoRepo dojoRepo;
	public MainService(NinjaRepo ninjaRepo, DojoRepo dojoRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
		
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
		
	}

	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
		
	}


	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
		
	}

	public Dojo findDojoById(Long id) {
		Optional<Dojo> optionaldojo = dojoRepo.findById(id);
		if(optionaldojo.isPresent()) {
			return optionaldojo.get();
		} else {
			return null;
	}
	
	}
}
