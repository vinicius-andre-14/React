package br.com.Apex.ApexLegends;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface lendaRepositorio extends CrudRepository<Lenda, Long>{
	
	List<Lenda> findByNome(String nome);
	List<Lenda> findByTipo(String tipo);
	List<Lenda> findByKills(int kills);
	List<Lenda> findByNroSkins(int nroSkins);
	
	//Lenda findById(Long id);
}
