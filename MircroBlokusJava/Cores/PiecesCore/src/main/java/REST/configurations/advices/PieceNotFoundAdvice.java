package REST.configurations.advices;

import REST.exceptions.PieceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PieceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PieceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pieceNotFoundHandler(PieceNotFoundException ex){ return ex.getMessage();
    }
}

