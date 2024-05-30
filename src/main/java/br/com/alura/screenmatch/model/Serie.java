package br.com.alura.screenmatch.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto incremento
    private Long id;
    //@Column(name = "nome_da_serie")
    @Column(unique = true)
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //mapeamento relacional, cascade faz com que os episodios sejam inseridos no banco
    private List<Episodio> episodios = new ArrayList<>();

    public Serie(){}

    public Serie(DadosSerie d){
        this.titulo = d.titulo();
        this.totalTemporadas = d.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(d.avaliacao())).orElse(0);
        this.genero  = Categoria.fromString(d.genero().split(",")[0]);
        this.atores = d.atores();
        this.poster = d.poster();
        this.sinopse = d.sinopse();
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "\nTítulo: '" + titulo + '\'' +
                "\nTotal de temporadas: " + totalTemporadas +
                "\nAvaliação: " + avaliacao +
                "\nGênero: " + genero +
                "\nAtores: '" + atores + '\'' +
                "\nPôster: '" + poster + '\'' +
                "\nSinopse: '" + sinopse + '\''+
                "\nEpisodios: "+ episodios + '\'';
    }
}
