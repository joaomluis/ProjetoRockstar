package GUI.MenuMusico;

public class Album {
    private String nome;
    private String genero;
    private String produtor;

    public Album(String nome, String genero, String produtor) {
        this.nome = nome;
        this.genero = genero;
        this.produtor = produtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
}
