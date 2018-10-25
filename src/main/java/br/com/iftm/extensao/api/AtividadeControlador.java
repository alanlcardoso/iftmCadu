package br.com.iftm.extensao.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade")
public class AtividadeControlador {

	@Autowired
	private AtividadeService servico;

	@GetMapping()
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(servico.buscarTodos());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {

		Optional<Atividade> atividade = servico.buscarPorId(id);

		if (!atividade.isPresent()) {
			return new ResponseEntity<Atividade>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(atividade.get());
	}

	@PostMapping
	public Atividade salvar(@RequestBody Atividade entidade) {
		return servico.salvar(entidade);
	}

	@PutMapping("/{id}/alterarNome")
	public void atualizarNome(@PathVariable Integer id, @RequestBody String nome) {
		servico.alterarNome(id, nome);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		servico.excluir(id);
	}
}
