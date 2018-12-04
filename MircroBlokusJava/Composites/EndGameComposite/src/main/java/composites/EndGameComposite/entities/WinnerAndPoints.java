package composites.EndGameComposite.entities;

import lombok.Data;

@Data
public class WinnerAndPoints {

    private String winner;

    private int redPlayerPoints;

    private int bluePlayerPoints;

    public WinnerAndPoints(String winner, int redPlayerPoints, int bluePlayerPoints) {
        this.winner = winner;
        this.redPlayerPoints = redPlayerPoints;
        this.bluePlayerPoints = bluePlayerPoints;
    }
}
