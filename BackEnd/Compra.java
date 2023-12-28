package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Compra implements Serializable {
    private Musica musica;
    private LocalDate data;
    private Cliente cliente;
    private static final long serialVersionUID = 1325672347L;

    public Compra(Musica musica, Cliente cliente) {
        this.musica = musica;
        this.cliente = cliente;
        this.data = LocalDate.now(); // Data da compra será a data atual
    }

    public Musica getMusica() {
        return musica;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
