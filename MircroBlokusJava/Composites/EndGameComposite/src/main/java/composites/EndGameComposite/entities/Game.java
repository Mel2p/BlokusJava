package composites.EndGameComposite.entities;

import lombok.Data;

@Data
public class Game {

    private String id;

    private String currentBoard;

    private int turn;

    private String userId;

    public Game(String id, String currentBoard, int turn, String userId) {
        this.id = id;
        this.currentBoard = currentBoard;
        this.turn = turn;
        this.userId = userId;
    }
}
