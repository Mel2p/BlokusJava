package composite.placePieceComposite.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {

    private String id;

    private String currentBoard;

    private int turn;

    private String userId;

    public Game(String currentBoard, int turn, String userId) {
        this.currentBoard = currentBoard;
        this.turn = turn;
        this.userId = userId;
    }
}
