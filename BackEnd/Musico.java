package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Musico extends User implements Serializable {
    private String pin;
    private ArrayList<Musica> musicas = new ArrayList<>();
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
        if(musicas !=null) {
            musicas.add(musica);
            System.out.println("add (Musico) Musicas do musico");
            for(Musica m: musicas){
                System.out.println(m);
            }
        }

    }

    @Override
    public String toString() {
        return super.getUsername();
    }
}
