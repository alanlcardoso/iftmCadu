package br.com.iftm.extensao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAtividadeRepositorio extends JpaRepository<Atividade, Integer> {

	List<Atividade> findByNomeContaining(String nome);
	
}