package br.com.cineclube.dao;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cineclube.model.Seriado;

public interface SeriadoRepository extends JpaRepository<Seriado, Long> {
	// findAll, findById, get, save, delete
}
