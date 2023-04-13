import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp(){
        biblioteca = new Biblioteca("Sebus");
    }

    @Test
    public void buscaNome(){
        assertEquals("Sebus", biblioteca.getNome());
    }

    @Test
    public void mudaNome(){
        biblioteca.setNome("Sebus1");
        assertEquals("Sebus1", biblioteca.getNome());
    }

    @Test
    public void retornaLivro(){
        List<Livro> listaDeLivros = new ArrayList<>();
        assertEquals(listaDeLivros, biblioteca.getLivros());
    }

    @Test
    public void adionaLivro(){
        assertTrue(biblioteca.adicionarLivro(criaLivro()));
    }

    @Test
    public void removeLivro(){
        assertTrue(biblioteca.adicionarLivro(criaLivro()));
        assertTrue(biblioteca.removerLivro(biblioteca.getLivros().get(0)));
    }

    @Test
    public void buscaPorTitulo(){
        Livro livro = criaLivro();
        assertTrue(biblioteca.adicionarLivro(livro));
        assertEquals(livro,biblioteca.buscarLivroPorTitulo("O código da Vinci"));
    }

    @Test
    public void buscaPorAutor(){
        Livro livro = criaLivro();
        List<Livro> listaDeLivros = new ArrayList<>();
        listaDeLivros.add(livro);
        assertTrue(biblioteca.adicionarLivro(livro));
        assertEquals(listaDeLivros,biblioteca.buscarLivrosPorAutor("Dan Brown"));
    }

    @Test
    public void buscaPorGenero(){
        Livro livro = criaLivro();
        List<Livro> listaDeLivros = new ArrayList<>();
        listaDeLivros.add(livro);
        assertTrue(biblioteca.adicionarLivro(livro));
        assertEquals(listaDeLivros,biblioteca.buscarLivrosPorGenero("Romance"));
    }

    @Test
    public void buscaQntd(){
        assertTrue(biblioteca.adicionarLivro(criaLivro()));
        assertEquals(1,biblioteca.getQuantidadeLivros());
    }

    public Livro criaLivro() {
        return new Livro("O código da Vinci","Dan Brown","Romance",2003);
    }
}

