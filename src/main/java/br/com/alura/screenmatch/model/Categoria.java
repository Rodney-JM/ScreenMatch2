package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    AVENTURA("Adventure", "Aventura"),
    CRIME("Crime", "Crime"),
    FICCAOCIENTIFICA("Science fiction", "Ficção Científica");

    private String categoriaOmdb;

    private String categoriaPort;

    Categoria(String categoriaOmdb, String categoriaPort){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPort = categoriaPort;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromPort(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPort.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
