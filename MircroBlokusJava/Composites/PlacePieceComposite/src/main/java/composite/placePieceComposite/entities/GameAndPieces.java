package composite.placePieceComposite.entities;

import lombok.Data;

import java.util.List;

@Data
public class GameAndPieces {
    Game game;

    List<Piece> allPieces;

    public GameAndPieces(Game game, List<Piece> allPieces) {
        this.game = game;
        this.allPieces = allPieces;
    }
}

