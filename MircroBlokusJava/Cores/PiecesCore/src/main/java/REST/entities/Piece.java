package REST.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Data
@Document
@AllArgsConstructor
public class Piece {

    @Id
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
