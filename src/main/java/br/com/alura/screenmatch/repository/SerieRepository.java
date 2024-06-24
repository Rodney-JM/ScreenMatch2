package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository <Serie, Long>{
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();//Desc faz de forma decrescente
    List<Serie> findByGenero(Categoria cat);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int numTemp, float avaMinima);

    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemp AND s.avaliacao >= :ava")
    List<Serie> seriesPorTemporadaEAvaliacao(int totalTemp, double ava);
}