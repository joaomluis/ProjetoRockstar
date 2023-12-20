package BackEnd;

public class Musica {
    private String tittle;
    private String artist;

    public Musica(String tittle, String artist) {
        this.tittle = tittle;
        this.artist = artist;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
