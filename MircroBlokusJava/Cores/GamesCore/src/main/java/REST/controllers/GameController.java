package REST.controllers;

import REST.entities.Game;
import REST.exceptions.GameNotFoundException;
import REST.repositories.GameRepository;
import REST.services.NextTurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    NextTurnService nextTurnServices;

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    List<Game> getAll(){
        return gameRepository.findAll();
    }

    @RequestMapping(value = "/games/{userId}", method = RequestMethod.POST)
    Game newGame(@PathVariable String userId){
        Game newgame = new Game(
                "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,]",
                0, userId);
        gameRepository.save(newgame);
        return newgame;
    }

    @RequestMapping(value = "/games/{id}", method =  RequestMethod.GET)
    Game getOne(@PathVariable String id){
        return gameRepository.findById(id)
                .orElseThrow(()-> new GameNotFoundException(id));
    }

    @PutMapping(value = "/games/{id}")
    Game replaceGame(@RequestBody Game newgame, @PathVariable String id){

        return gameRepository.findById(id)
                .map(Game -> {
                    Game.setId(newgame.getId());
                    Game.setCurrentBoard(newgame.getCurrentBoard());
                    Game.setTurn(newgame.getTurn());
                    return  gameRepository.save(Game);
                })
                .orElseGet(()-> {
                    newgame.setId(id);
                    return gameRepository.save(newgame);
                });
    }

    @RequestMapping(value = "/games/{id}/next_turn", method = RequestMethod.GET)
    Game nextTurn(@PathVariable String id){
       return nextTurnServices.nextTurn(id);
    }


}
