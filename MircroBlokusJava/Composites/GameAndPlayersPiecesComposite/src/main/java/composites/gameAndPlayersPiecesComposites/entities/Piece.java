package composites.gameAndPlayersPiecesComposites.entities;

import lombok.Data;

@Data
public class Piece {

    private String id;

    private int value;

    private String shape;

    private boolean played;

    public Piece(String id, int value, String shape, boolean played) {
        this.id = id;
        this.value = value;
        this.shape = shape;
        this.played = played;
    }
}
