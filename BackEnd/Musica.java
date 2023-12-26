package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Musica implements Serializable {
    private String title;
    private Musico artist;
    private String genre;
    private double preco;
    private ArrayList<Preco> historicoPreco = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>(); //<User, Avaliação>

    public Musica(String tittle, Musico artist, String genre, double preco) {
        this.title = tittle;
        this.artist = artist;
        this.genre = genre;
        this.preco = preco;
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

    public Musico getArtist() {
        return artist;
    }

    public void setArtist(Musico artist) {
        this.artist = artist;
    }

    /**
     * GetPreço, para saber o preço da música
     * @return Preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Ver o historico de precos da musica
     * @return ArrayList com todos os preços anteriores e data de modificação
     */
    public ArrayList<Preco> getHistoricoPreco(){
        return historicoPreco;
    }

    /**
     * Caso a alteração de preço seja feita pelo artista da música,
     * será bem-sucedida e adicionada ao hostirico de preços
     * @param preco novo preço
     * @param artista artista que está a fazer a alteração
     * @return true se a alteração foi bem-sucedida e false caso contrário
     */
    public boolean alterarPreco(Double preco, User artista){
        if(artista.equals(artist)){
            historicoPreco.add(new Preco(preco));
            this.preco = preco;
            return true;
        }
        return false;
    }

    /**
     * Adiciona uma avaliação à música, verificando se o cliente já a avaliou previamente
     * @param avaliacao Avaliação do cliente em relação à música
     * @param cliente Cliente que pretende adicionar a avaliação
     * @return true se o cliente está a avaliar a música pela 1ª vez e realiza a avaliação e false caso já tenha avaliado a música anteriormente
     */
    public boolean adicionarAvaliacao(Avaliacao avaliacao, Cliente cliente){
        for(Avaliacao a : avaliacoes){
            if(a.getCliente().equals(cliente)){
                return false;
            }
        }
        avaliacoes.add(avaliacao);
        return true;
    }
}
