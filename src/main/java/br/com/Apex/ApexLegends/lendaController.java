package br.com.Apex.ApexLegends;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/lenda")
@CrossOrigin(origins = "*")
public class lendaController {
	
	@Autowired
	private lendaRepositorio repositorio;
	
	@PostMapping(path="/add")
	public @ResponseBody String novoUsuario(@RequestParam String nome,
				@RequestParam String tipo,@RequestParam int kills,@RequestParam int nroSkins) {
		Lenda user = new Lenda();
		user.setNome(nome);
		user.setTipo(tipo);
		user.setKills(kills);
		user.setNroSkins(nroSkins);
		repositorio.save(user);
		return "Lenda adicionada com sucesso";
	}
	
	@PostMapping(path="/adduser")
	public @ResponseBody String novoUsuario2(@RequestBody Lenda newUser) {
			repositorio.save(newUser);
		return "Valores salvos com sucesso";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Lenda> retornaTodos(){
		return repositorio.findAll();
	}
	
	@GetMapping(path="/user")
	public @ResponseBody Optional<Lenda> retornaUser (@RequestParam String id){
		return repositorio.findById(Long.parseLong(id));
	}
	
	@GetMapping(path="/locate_user/{id}")
	public @ResponseBody Optional<Lenda> retornaUser2 (@PathVariable(required = true, name="id")
	Long id){
		return repositorio.findById(id);
	}
	//delete
	@DeleteMapping(path="delete_user/{id}")
	public @ResponseBody String deleteUser (@PathVariable(required = true, name = "id")Long id) {
		Optional<Lenda> user = repositorio.findById(id);
		if(user.isPresent()) {
			repositorio.delete(user.get());
			return "Lenda deletada com sucesso";
		}
		return "Lenda não encontrada";
	}
	
	@PutMapping(path="/update_user/{id}")
	public @ResponseBody Optional<Lenda> updateUser(@PathVariable (required = true, name = "id") Long id
			,@RequestBody Lenda user){
		Optional<Lenda> u = repositorio.findById(id);
		if(u.isPresent()) {
			u.get().setNome(user.getNome());
			u.get().setTipo(user.getTipo());
			u.get().setKills(user.getKills());
			u.get().setNroSkins(user.getNroSkins());
			repositorio.save(u.get());
			return u;
		}
		return null;
	}
	
	@PutMapping(path="/user/{id}")
	public @ResponseBody ResponseEntity<Lenda> alteraUser(@PathVariable (required = true, name = "id") Long id
			,@RequestBody Lenda user){
		Optional<Lenda> u = repositorio.findById(id);
		if(u.isPresent()) {
			u.get().setNome(user.getNome());
			u.get().setTipo(user.getTipo());
			u.get().setKills(user.getKills());
			u.get().setNroSkins(user.getNroSkins());
			repositorio.save(u.get());
			return ResponseEntity.ok(repositorio.save(u.get()));
		}
		return ResponseEntity.status(404).build();
	}
	
	@GetMapping(path="locate_by_nome/{nome}")
	public @ResponseBody List<Lenda> locateByNome(@PathVariable(required = true, name = "nome") String nome){
		return repositorio.findByNome(nome);
	}
	
	@GetMapping(path="locate_by_tipo/{tipo}")
	public @ResponseBody List<Lenda> locateByTipo(@PathVariable(required = true, name = "tipo") String tipo){
		return repositorio.findByTipo(tipo);
	}
	
	@GetMapping(path="locate_by_kills/{kills}")
	public @ResponseBody List<Lenda> locateByKills(@PathVariable(required = true, name = "kills") int kills){
		return repositorio.findByKills(kills);
	}
	
	@GetMapping(path="locate_by_nroSkins/{nroSkins}")
	public @ResponseBody List<Lenda> locateByNroSkins(@PathVariable(required = true, name = "nroSkins") int nroSkins){
		return repositorio.findByNroSkins(nroSkins);
	}

}
