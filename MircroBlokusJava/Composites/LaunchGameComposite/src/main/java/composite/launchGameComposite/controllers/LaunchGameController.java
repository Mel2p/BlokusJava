package composite.launchGameComposite.controllers;

import composite.launchGameComposite.entities.GameAndAllPieces;
import composite.launchGameComposite.services.LaunchGameService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaunchGameController {

    @Setter
    @Autowired
    LaunchGameService launchGameService;

    @RequestMapping("/game/new/{id}")
    ResponseEntity<GameAndAllPieces> getNewGame(@PathVariable String id){
        return new ResponseEntity<>(launchGameService.returnNewGameWithAllPieces(id), HttpStatus.OK);
    }

}
