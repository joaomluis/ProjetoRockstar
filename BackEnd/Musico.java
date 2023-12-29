package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Musico extends User implements Serializable {
    private String pin;
    private ArrayList<Musica> musicas = new ArrayList<>();
    private ArrayList<Album> albuns = new ArrayList<>();
    private static final long serialVersionUID = 1325672347L;
    public Musico(String username, String password, String pin) {
        super(username, password);
        this.pin = pin;
    }

    public Musico() {
        super();
        this.pin = "";
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public void addMusica(Musica musica) {
        if(musicas == null) {
            musicas = new ArrayList<>();
            System.out.println("add (Musico) Musicas do musico");
        }
        musicas.add(musica);
        for(Musica m: musicas){
            System.out.println(m);
        }
    }
    public void addMusicaAlbum(Musica musica, Album album){
        if(albuns == null) {
            albuns = new ArrayList<>();
            System.out.println("1ª musica do album");
        }
        for(Album a : albuns){
            if (a == album) {
                a.adicionarMusica(musica);
            }
        }
    }

    public ArrayList<Album> getAlbuns() {
        return albuns;
    }
    public void addAlbum(Album album){
        if(albuns == null) {
            albuns = new ArrayList<>();//para evitar o erro de null exception
        }
        albuns.add(album);
        System.out.println("add album ao musicoAlbuns");
    }

    @Override
    public String toString() {
        return super.getUsername();
    }
}
