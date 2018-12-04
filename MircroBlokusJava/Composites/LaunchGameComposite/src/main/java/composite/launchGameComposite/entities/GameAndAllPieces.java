package composite.launchGameComposite.entities;

import lombok.Data;

import java.util.List;

@Data
public class GameAndAllPieces {

    private String id_game;

    private String currentBoard;

    private int turn;

    private String userId;

    private List<Piece> allPieces;

    public GameAndAllPieces(String id_game, String currentBoard, int turn, String userId, List<Piece> allPieces) {
        this.id_game = id_game;
        this.currentBoard = currentBoard;
        this.turn = turn;
        this.userId = userId;
        this.allPieces = allPieces;
    }
}
