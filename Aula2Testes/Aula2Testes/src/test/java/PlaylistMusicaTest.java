import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class PlaylistMusicaTest {
    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setUp(){
        playlistMusica = new PlaylistMusica("Rapzada");
    }

    @Test
    public void retornaNome(){
        assertEquals("Rapzada", playlistMusica.getNome());
    }

    @Test
    public void mudaNome(){
        playlistMusica.setNome("Rapzada2");
        assertEquals("Rapzada2",playlistMusica.getNome());
    }

    @Test
    public void retornaMusicas(){
        List<Musica> teste = new ArrayList();
        List<Musica> retorno = playlistMusica.getMusicas();
        assertEquals(teste,retorno);
    }

    @Test
    public void adicionaMusica(){
        Musica musica = new Musica("In the end","Linkin Park",210);
        assertTrue(playlistMusica.adicionarMusica(musica));
    }
    @Test
    public void removerMusica(){
        Musica musica = new Musica("In the end","Linkin Park",210);
        assertTrue(playlistMusica.adicionarMusica(musica));
        assertTrue(playlistMusica.removerMusica(playlistMusica.getMusicas().get(0)));
    }

    @Test
    public void buscaPorTitulo(){
        Musica musica = new Musica("In the end","Linkin Park",210);
        assertTrue(playlistMusica.adicionarMusica(musica));
        assertEquals(musica,playlistMusica.buscarMusicaPorTitulo("In the end"));
    }

    @Test
    public void buscaPorArtista(){
        Musica musica = new Musica("In the end","Linkin Park",210);
        List<Musica> teste = new ArrayList<>();
        teste.add(musica);
        assertTrue(playlistMusica.adicionarMusica(musica));
        assertEquals(teste,playlistMusica.buscarMusicasPorArtista("Linkin Park"));
    }

    @Test
    public void ordenaListaPorTitulo(){
        Musica musica1 = new Musica("In the end","Linkin Park",210);
        Musica musica2 = new Musica("Sicko mode","Travis Scott",320);
        Musica musica3 = new Musica("The devil in I","Slipknot",210);

        assertTrue(playlistMusica.adicionarMusica(musica3));
        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertTrue(playlistMusica.adicionarMusica(musica2));

        playlistMusica.ordenarPorTitulo();
        assertEquals(musica1, playlistMusica.getMusicas().get(0));
        assertEquals(musica2, playlistMusica.getMusicas().get(1));
        assertEquals(musica3, playlistMusica.getMusicas().get(2));
    }

    @Test
    public void ordenaListaPorArtista(){
        Musica musica1 = new Musica("In the end","Linkin Park",210);
        Musica musica2 = new Musica("Sicko mode","Travis Scott",320);
        Musica musica3 = new Musica("The devil in I","Slipknot",210);

        assertTrue(playlistMusica.adicionarMusica(musica3));
        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertTrue(playlistMusica.adicionarMusica(musica2));

        playlistMusica.ordenarPorArtista();

        assertEquals(musica1, playlistMusica.getMusicas().get(0));
        assertEquals(musica3, playlistMusica.getMusicas().get(1));
        assertEquals(musica2, playlistMusica.getMusicas().get(2));

    }

    @Test
    public void qntdMusicas() {
        Musica musica1 = new Musica("In the end","Linkin Park",210);
        assertTrue(playlistMusica.adicionarMusica(musica1));
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }

}
