package br.com.Apex.ApexLegends;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface armasRepositorio extends CrudRepository<Armas, Long>{
	
	List<Armas> findByNome(String nome);
	List<Armas> findByTipo(String tipo);
	List<Armas> findByMunicao(String municao);
	List<Armas> findBynroSkins(int nroSkins);
	List<Armas> findByDano(int dano);
	List<Armas> findByDanohs(int danohs);

}
