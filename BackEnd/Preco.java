package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
//Seria melhor usar a classe Preco como abstrata?
//Ela apenas serve para instanciar o historico de precos de uma musica.
public class Preco implements Serializable {
    private double preco;
    private LocalDate data;

    public Preco(double preco){
        this.preco = preco;
        this.data = LocalDate.now();
    }
    public double getPreco(){
        return preco;
    }
}
