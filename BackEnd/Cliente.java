package BackEnd;

import java.util.ArrayList;

public class Cliente extends User{
    private ArrayList<Musica> historicoCompras;
    private ArrayList<Playlist> playlists;
    private ArrayList<Musica> carrinhoCompras;
    private double saldo;

    public Cliente(String username, String password) {
        super(username, password);
        historicoCompras = new ArrayList<>();
        playlists = new ArrayList<>();
        carrinhoCompras = new ArrayList<>();
    }
    /**
     * Cria uma playlist aleatória especificando o gênero musical e o número de musicas. E retorna a nova PlayList.
     * @return true se a playlist foi criada, false caso contrário.
     */
    public boolean criarPlaylist(String nomePlaylist) {
        //Verifica se o nome da playlist ja existe na lista de playlists.
        for (Playlist pl : playlists) {
            if (pl.getNome().equals(nomePlaylist)) return false;
            else {
                playlists.add(new Playlist(nomePlaylist, this));
            }
        }
        return true;
    }
    public ArrayList<Musica> criarPlaylist(String genero, int numMusicas){
        ArrayList<Musica> novaPlaylist = new ArrayList<>();
        ArrayList<Musica> musicasDoGenero = new ArrayList<>();
        //Verifica quantas músicas o usuario tem daquele genero
        for(Musica m : historicoCompras){
            if(m.getGenre().equals(genero) && !musicasDoGenero.contains(m) && musicasDoGenero.size()<=numMusicas){
                musicasDoGenero.add(m);
            }
        }
        //Em caso de o número de músicas daquele genero for menor que o especificado, atualizamos o numero para esse número.
        if(musicasDoGenero.size() < numMusicas) numMusicas = musicasDoGenero.size();
        //Percorre as músicas do cliente e adiciona-as na playlist com o genero especificado.
        while(novaPlaylist.size() < numMusicas){
            for (Musica m : historicoCompras) {
                if(m.getGenre().equals(genero) && !novaPlaylist.contains(m)){
                    novaPlaylist.add(m);
                }
            }
        }
        //Adiciona a nova Playlist à lista de playlists do Cliente.
        playlists.add(new Playlist("Playlist de "+genero, novaPlaylist, this));
        //Retorna a nova playlist
        return novaPlaylist;
    }
    /**
     * Retorna o historico de compras do cliente (músicas do cliente).
     * @return historicoCompras
     */
    public ArrayList<Musica> musicas() {
        return historicoCompras;
    }
    /**
     * Pede todas as playlists do cliente.
     * @return playlists
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    /**
     * Cria uma Playlist vazia com o nome pertendido.
     * @param nomePlaylist
     */
    /**
     * Remove uma playlist do cliente.
     * @param nomePlaylist
     * @return true se a playlist existir e false caso contrário
     */
    public boolean removerPlaylist(String nomePlaylist){
        //Verifica se o nome da playlist existe na lista de playlists.
        for (Playlist pl: playlists) {
            //Se existir, remove-a.
            if(pl.getNome().equals(nomePlaylist)){
                playlists.remove(pl);
                return true;
            }
        }
        //Se não existir, retorna falso.
        return false;
    }
    /**
     * Adiciona saldo à conta do Cliente
     * @param valor
     * @return true se o valor for positivo e false caso contrário
     */
    public boolean adicionaSaldo(double valor){
        if(valor >= 0){
            saldo += valor;
            return true;
        }
        else return false;
    }
    /**
     * Adiciona música ao carrinho de compras.
     * @param musica
     * @return true se a música não estiver no carrinho e false caso contrário
     */
    public boolean adicionaCarrinho(Musica musica){
        for(Musica m: carrinhoCompras){
            if(carrinhoCompras.contains(musica)){
                return false;
            }
        }
        carrinhoCompras.add(musica);
        return true;
    }
    /**
     * Finaliza a compra das musicas presentes no carrinho.
     * @return true se a divida for menor que o saldo e false caso contrário
     */
    public boolean finalizaCompra(){
        double divida =0;
        //Calcula a divida
        for (Musica m : carrinhoCompras) {
            divida += m.getPreco();
        }
        if(divida > saldo){
            //Se a divida for maior que o saldo, retorna falso.
            return false;
        }else {
            //Se a divida for menor ou igual ao saldo, finaliza a compra e retorna true.
            historicoCompras.addAll(carrinhoCompras);
            carrinhoCompras.clear();
            return true;
        }
    }
    public void alterarVisibilidadePlaylist(Playlist nomePlaylist){
        nomePlaylist.alterarVisibilidade();
    }
}
