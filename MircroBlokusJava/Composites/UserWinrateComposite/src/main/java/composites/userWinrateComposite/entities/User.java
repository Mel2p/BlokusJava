package composites.userWinrateComposite.entities;

import lombok.Data;

@Data
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

    private int numberOfWin;

    private int numberOfGames;

    public User(String id, String username, String password, String email, int numberOfWin, int numberOfGames) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numberOfWin = numberOfWin;
        this.numberOfGames = numberOfGames;
    }
}
