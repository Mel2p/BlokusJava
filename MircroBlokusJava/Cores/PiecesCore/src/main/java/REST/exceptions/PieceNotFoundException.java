package REST.exceptions;

public class PieceNotFoundException extends RuntimeException{

    public PieceNotFoundException(String id){
        super("Piece not found : "  + id);
    }
}