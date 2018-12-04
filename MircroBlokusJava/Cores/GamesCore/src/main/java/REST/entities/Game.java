package REST.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@AllArgsConstructor
public class Game {

    @Id
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