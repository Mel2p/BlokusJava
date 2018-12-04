package composites.EndGameComposite.controllers;

import composites.EndGameComposite.entities.WinnerAndPoints;
import composites.EndGameComposite.services.EndGameService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndGameController {

    @Autowired
    @Setter
    EndGameService endGameService;

    @RequestMapping("/game/{id}/end")
    ResponseEntity<WinnerAndPoints> endGame(@PathVariable String id){
        return new ResponseEntity<>(endGameService.finalScore(id), HttpStatus.OK);
    }
}
