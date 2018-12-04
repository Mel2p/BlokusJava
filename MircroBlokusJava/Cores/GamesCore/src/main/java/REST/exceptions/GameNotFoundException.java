package REST.exceptions;

public class GameNotFoundException extends RuntimeException{

    public GameNotFoundException(String id){
        super("user not found : "  + id);
    }
}
