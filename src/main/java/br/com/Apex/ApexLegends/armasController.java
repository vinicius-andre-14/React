package br.com.Apex.ApexLegends;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/armas")
@CrossOrigin(origins = "*")
public class armasController {
	
	@Autowired
	private armasRepositorio repositorio2;
	
	@PostMapping(path="/add")
	public @ResponseBody String novaArma(@RequestParam String nome,
				@RequestParam String tipo,@RequestParam String municao,@RequestParam int nroSkins,
				@RequestParam int dano,@RequestParam int danohs) {
		Armas weapon = new Armas();
		weapon.setNome(nome);
		weapon.setTipo(tipo);
		weapon.setMunicao(municao);
		weapon.setNroSkins(nroSkins);
		weapon.setDano(dano);
		weapon.setDanohs(danohs);
		repositorio2.save(weapon);
		return "Arma adicionada com sucesso";
	}
	
	@PostMapping(path="/addweapon")
	public @ResponseBody String novoUsuario2(@RequestBody Armas weapon) {
			repositorio2.save(weapon);
		return "Valores salvos com sucesso";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Armas> retornaTodos(){
		return repositorio2.findAll();
	}
	
	@GetMapping(path="/weapons")
	public @ResponseBody Optional<Armas> retornaUser (@RequestParam String id){
		return repositorio2.findById(Long.parseLong(id));
	}
	
	@GetMapping(path="/locate_arma/{id}")
	public @ResponseBody Optional<Armas> retornaArmas (@PathVariable(required = true, name="id")
	Long id){
		return repositorio2.findById(id);
	}
	//delete
	@DeleteMapping(path="delete_arma/{id}")
	public @ResponseBody String deleteArma (@PathVariable(required = true, name = "id")Long id) {
		Optional<Armas> user = repositorio2.findById(id);
		if(user.isPresent()) {
			repositorio2.delete(user.get());
			return "Arma deletada com sucesso";
		}
		return "Arma não encontrada";
	}
		
	@PutMapping(path="/update_arma/{id}")
	public @ResponseBody Optional<Armas> updateUser(@PathVariable (required = true, name = "id") Long id
			,@RequestBody Armas user){
		Optional<Armas> u = repositorio2.findById(id);
		if(u.isPresent()) {
			u.get().setNome(user.getNome());
			u.get().setTipo(user.getTipo());
			u.get().setMunicao(user.getMunicao());
			u.get().setNroSkins(user.getNroSkins());
			u.get().setDano(user.getDano());
			u.get().setDanohs(user.getDanohs());
			repositorio2.save(u.get());
			return u;
		}
		return null;
	}
	
	@GetMapping(path="locate_by_nome/{nome}")
	public @ResponseBody List<Armas> locateByNome(@PathVariable(required = true, name = "nome") String nome){
		return repositorio2.findByNome(nome);
	}
	
	@GetMapping(path="locate_by_tipo/{tipo}")
	public @ResponseBody List<Armas> locateByTipo(@PathVariable(required = true, name = "tipo") String tipo){
		return repositorio2.findByTipo(tipo);
	}
	
	@GetMapping(path="locate_by_municao/{municao}")
	public @ResponseBody List<Armas> locateByMunicao(@PathVariable(required = true, name = "municao") String municao){
		return repositorio2.findByMunicao(municao);
	}			
	
	@GetMapping(path="locate_by_nroskins/{nroSkins}")
	public @ResponseBody List<Armas> locateBynroSkins(@PathVariable(required = true, name = "nroSkins") int nroSkins){
		return repositorio2.findBynroSkins(nroSkins);
	}
	
	@GetMapping(path="locate_by_dano/{dano}")
	public @ResponseBody List<Armas> locateByDano(@PathVariable(required = true, name = "dano") int dano){
		return repositorio2.findByDano(dano);
	}
	
	@GetMapping(path = "locate_by_hs/{danohs}")
	public @ResponseBody List<Armas> locateByHS(@PathVariable(required = true, name = "danohs") int danohs){
		return repositorio2.findByDanohs(danohs);
	}
}
