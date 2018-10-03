package br.com.iftm.extensao.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

	@Autowired
	private IAtividadeRepositorio repo;

	public List<Atividade> buscarTodos() {
		return repo.findAll();
	}

	public Atividade salvar(Atividade entidade) {
		return repo.save(entidade);
	}
	
	public List<Atividade> buscarPorNome(String nome) {
		return repo.findByNomeContaining(nome);
	}

	public Optional<Atividade> buscarPorId(Integer id) {
		return repo.findById(id);
	}

}
