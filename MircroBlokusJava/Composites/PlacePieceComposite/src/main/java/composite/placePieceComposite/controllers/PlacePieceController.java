package composite.placePieceComposite.controllers;

import composite.placePieceComposite.entities.GameAndPieces;
import composite.placePieceComposite.services.PlacePieceService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlacePieceController {
    @Autowired
    @Setter
    PlacePieceService placePieceService;

    @RequestMapping("/game/{gameId}/{pieceId}/place_piece")
    ResponseEntity<GameAndPieces> placeOnePiece(@PathVariable String gameId, @PathVariable String pieceId){
        return new ResponseEntity<>(placePieceService.placePiece(gameId, pieceId), HttpStatus.OK );
    }
}
