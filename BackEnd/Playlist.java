package BackEnd;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Playlist implements Serializable {
    private String nome;
    private ArrayList<Musica> musicas;
    private boolean visibilidade;
    private Cliente autor;
    private static final long serialVersionUID = 1325672347L;

    /**
     * Criará uma Playlist para o Cliente, apenas com um nome.
     * @param nome
     */
    public Playlist(String nome, Cliente cliente) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.visibilidade = true;
        this.autor = cliente;
    }

    /**
     * Contrutor que contem todos os parametros na criação de uma nova Playlist.
     * @param nome
     * @param musicas
     */
    public Playlist(String nome, ArrayList<Musica> musicas, Cliente cliente) {
        this.nome = nome;
        this.musicas = musicas;
        this.visibilidade = true; //Por defeito, as playlists sao visíveis.
        this.autor = cliente;
    }

    /**
     * Adicionar uma música à Playlist.
     * Verificar se a música está na playlist antes de a adicionar.
     * @param musica
     */
    public void adicionarMusica(Musica musica){
        if(!musicas.contains(musica)) musicas.add(musica);
    }
    /**
     * Remover uma música da Playlist.
     * Verificar se a música está na playlist antes de a tentar remover.
     * @param musica
     */
    public void removerMusica(Musica musica){
        if(musicas.contains(musica)) musicas.remove(musica);
    }
    /**
     * Altera a visibilidade da Playlist.
     */
    public void alterarVisibilidade(){
        visibilidade = !visibilidade;
    }
    /**
     * Altera a visibilidade da Playlist para a que o usuario pedir.
     */
    public void alterarVisibilidadePlaylist(boolean visibilidade){
        this.visibilidade = visibilidade;

    }
    public String getNome() {
        return nome;
    }
}

