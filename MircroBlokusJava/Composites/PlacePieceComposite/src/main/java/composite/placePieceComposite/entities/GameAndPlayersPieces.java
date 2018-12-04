package composite.placePieceComposite.entities;

import lombok.Data;

import java.util.List;

@Data
public class GameAndPlayersPieces {

    private Game game;

    private List<Piece> bluePlayersPieces;

    private List<Piece> redPlayersPieces;

    public GameAndPlayersPieces(Game game, List<Piece> bluePlayersPieces, List<Piece> redPlayersPieces) {
        this.game = game;
        this.bluePlayersPieces = bluePlayersPieces;
        this.redPlayersPieces = redPlayersPieces;
    }
}
