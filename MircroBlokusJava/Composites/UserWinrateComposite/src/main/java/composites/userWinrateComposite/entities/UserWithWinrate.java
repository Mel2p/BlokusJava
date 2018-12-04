package composites.userWinrateComposite.entities;

import lombok.Data;

@Data
public class UserWithWinrate {
    private String id;

    private String username;

    private String password;

    private String email;

    private int numberOfWin;

    private int numberOfGames;

    private double winrate;

    public UserWithWinrate(String id, String username, String password, String email, int numberOfWin, int numberOfGames, double winrate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numberOfWin = numberOfWin;
        this.numberOfGames = numberOfGames;
        this.winrate = winrate;
    }
}