package composites.EndGameComposite.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Piece {

    private String id;

    private int value;

    private String shape;

    private boolean played;

    public Piece(int value, String shape, boolean played) {
        this.value = value;
        this.shape = shape;
        this.played = played;
    }
}
