package REST.services;

import REST.entities.Game;
import REST.repositories.GameRepository;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class NextTurnService {

    @Autowired
    @Setter
    GameRepository gameRepository;

    Game currentGame;

    public Game nextTurn(String id){

        if(gameRepository.findById(id) != null ) {

            currentGame = gameRepository.findById(id).get();

            int lastTurn = currentGame.getTurn();
            int currentTurn = lastTurn+1;
            currentGame.setTurn(currentTurn);


            gameRepository.findById(id)
                    .map(Game -> {
                        Game.setTurn(currentGame.getTurn());
                        return  gameRepository.save(Game);
                    });
        }

        return currentGame;
    }
}
