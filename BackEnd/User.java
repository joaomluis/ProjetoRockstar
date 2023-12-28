package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    private String username;
    private String password;
    private static final long serialVersionUID = 1325672347L;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        this.username = "";
        this.password = "";

    }

    // Getters para username e password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void listarMusicas(){

    }
    public boolean adicionaSaldo(double valor){

        return false;
    }


    public double getSaldo() {
        return 0;
    }
}
