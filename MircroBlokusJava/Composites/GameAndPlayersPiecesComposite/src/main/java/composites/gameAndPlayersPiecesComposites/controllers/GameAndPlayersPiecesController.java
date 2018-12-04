package composites.gameAndPlayersPiecesComposites.controllers;

import composites.gameAndPlayersPiecesComposites.entities.GameAndPlayersPieces;
import composites.gameAndPlayersPiecesComposites.services.GameAndPlayersPiecesService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameAndPlayersPiecesController {

    @Autowired
    @Setter
    GameAndPlayersPiecesService gameAndPlayersPiecesService;

    @RequestMapping("game/finalobject/{id}")
    ResponseEntity<GameAndPlayersPieces> gameAndPlayersPieces(@PathVariable String id){
        return new ResponseEntity<>(gameAndPlayersPiecesService.gameAndPlayersPieces(id), HttpStatus.OK);
    }
}
