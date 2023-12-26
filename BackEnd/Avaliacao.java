package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Avaliacao implements Serializable {
    private double avaliacao;
    private LocalDate data;
    private Cliente cliente;

    public Avaliacao(double avaliacao, Cliente cliente) {
        this.avaliacao = avaliacao;
        this.cliente = cliente;
        this.data = LocalDate.now();
    }
    //** Getters ***/
    /**
     * Geter para avaliação
     * @return avaliacao
     */
    public double getAvaliacao() {
        return avaliacao;
    }
    /**
     * Geter para data da avaliação
     * @return data
     */
    public LocalDate getData() {
        return data;
    }
    /**
     * Geter para cliente que a avaliou
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}
