package BackEnd;

public class Musico extends User{
    private String pin;
    public Musico(String username, String password, String pin) {
        super(username, password);
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
