package br.com.cineclube.dao;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cineclube.model.Seriado;

public interface SeriadoRepository extends JpaRepository<Seriado, Long> {
	// findAll, findById, get, save, delete
//   List<Seriado> findByCategory(String category);

//   List<Seriado> findByName(String name);

//   List<Seriado> findAll();

  // List<Seriado> findByNameAndCategory(String name, String category);

  // List<Seriado> findByNameOrCategory(String name, String category);

  // List<Seriado> findByOrderByCategory();

  // List<Seriado> findByOrderByCategoryDesc();

//   List<Seriado> findByScoreGreaterThan(Float score);

//   List<Seriado> findByScoreGreaterThanEqual(Float score);

//   List<Seriado> findByScoreLessThanEqual(Float score);

//   List<Seriado> findTop3ByScoreGreaterThanEqualOrderByScoreDesc(Float score);

//   List<Seriado> findByScoreBetween(Float min, Float max);

  // boolean existsSeriadoByCategory(String category);

  // @Query("select f from Seriado f where f.category = ?1")
  // List<Seriado> selectSeriadoByCategory(String category);

  // @Query("select f from Seriado f join f.persons p where p.name = ?1 and
  // f.category = ?2")
  // List<Seriado> findByPersonAndCategory(String name, String category);

}
