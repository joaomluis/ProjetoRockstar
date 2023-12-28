package BackEnd;

import java.io.Serializable;

public class Musico extends User implements Serializable {
    private String pin;
    private static final long serialVersionUID = 1325672347L;
    public Musico(String username, String password, String pin) {
        super(username, password);
        this.pin = pin;
    }

    public Musico() {
        super();
        this.pin = "";
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
