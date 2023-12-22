package BackEnd;

public class Musica {
    private String title;
    private String artist;
    private String genre;
    private double preco;

    public Musica(String tittle, String artist, String genre) {
        this.title = tittle;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPreco() {
        return preco;
    }
}
