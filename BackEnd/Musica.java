package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Musica implements Serializable {
    private String title;
    private Musico artist;
    private String genre;
    //private double preco;
    private ArrayList<Preco> historicoPreco = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>(); //<User, Avaliação>
    private boolean visibilidade;
    private static final long serialVersionUID = 1325672347L;

    public Musica(String tittle, Musico artist, String genre, double preco) {
        this.title = tittle;
        this.artist = artist;
        this.genre = genre;
        //this.preco = preco;
    }

    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public Musico getArtist() {
        return artist;
    }

    /**
     * GetPreço, para saber o preço da música
     * @return Preco
     */
    public double getPreco() {
        //return preco;
        return historicoPreco.get(historicoPreco.size()-1).getPreco();
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
        if(artista.equals(artist) && preco >= 0){
            historicoPreco.add(new Preco(preco));
//            this.preco = preco;
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

    public boolean isVisibilidade() {
        return visibilidade;
    }
    public void alterarVisibilidade(){
        this.visibilidade = !visibilidade;
    }
    public boolean alterarTitulo(String novoNome){
        if(novoNome != null && !novoNome.equals(" ")){
            title = novoNome;
            return true;
        }
        return false;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Avaliação média da música.
     * Caso não tenha avaliações, a música terá como default a avaliação de 3 que será intermédia.
     * Se tiver avaliações, fará a média de todas as avaliações da música.
     * @return 3 (default) ou a média real da musica
     */
    public double avaliacaoMedia(){
        double soma=0;
        if(avaliacoes.isEmpty()){
            return 3;
        }else{
            for (Avaliacao a: avaliacoes){
                soma += a.getAvaliacao();
            }
        }
        return soma/avaliacoes.size();
    }
}
