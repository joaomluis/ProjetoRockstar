package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
    private String title;
    private Musico artist;
    private String genre;
    private ArrayList<Musica> musicas;
    private static final long serialVersionUID = 1325672347L;

    public Album(String title, Musico artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.musicas = new ArrayList<>();
    }

    /**
     * Adiciona música ao album. Verifica se não é repetida.
     * @param musica
     * @return true se a adição foi bem-sucedida, false caso contrário
     */
    public boolean adicionarMusica(Musica musica){
        if(!musicas.contains(musica)){
            musicas.add(musica);
            return true;
        }else {
            return false;
        }
    }
    /**
     * Remove uma musica do album. Verifica se existe antes de a remover.
     * @param musica
     * @return true se a remocão for bem-sucedida, false caso contrário
     */
    public boolean removerMusica(Musica musica){
        if(musicas.contains(musica)){
            musicas.remove(musica);
            return true;
        }else{
            return false;
        }
    }
    /**
     * Para obter as musicas do album
     * @return as musicas do album
     */
    public ArrayList<Musica> getMusicas(){
        return musicas;
    }
    /**
     * Para obter o nome do album
     * @return o nome do album
     */
    public String getTitle() {
        return title;
    }
    /**
     * Para obter o genero do album
     * @return o genero do album
     */
    public String getGenre() {
        return genre;
    }
}
