package BackEnd;

import java.util.ArrayList;

public abstract class User {
    private String username;
    private String password;
    private ArrayList<Playlist> playlists ;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
