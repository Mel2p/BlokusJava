package composites.EndGameComposite.services;

import composites.EndGameComposite.clients.IGameAndPlayersPiecesClient;
import composites.EndGameComposite.entities.GameAndPlayersPieces;
import composites.EndGameComposite.entities.Piece;
import composites.EndGameComposite.entities.WinnerAndPoints;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EndGameService {

    String winner;
    int bluePlayerPoints = 0 ;
    int redPlayerPoints = 0;

    @Setter
    private IGameAndPlayersPiecesClient iGameAndPlayersPiecesClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameAndPlayersPiecesClient.class, "http://localhost:8047/game/finalobject/{id}");

    public WinnerAndPoints finalScore(String gameId){

        log.info("call to the GameAndPlayersPieces core - getOneById : "+gameId);
        GameAndPlayersPieces currentGameAndPlayersPieces = iGameAndPlayersPiecesClient.getOneById(gameId);

        List<Piece> bluePieces = currentGameAndPlayersPieces.getBluePlayersPieces();
        List<Piece> redPieces = currentGameAndPlayersPieces.getRedPlayersPieces();

        bluePieces.stream()
                .filter(p -> p.isPlayed() == false )
                .forEach(p -> bluePlayerPoints =+ p.getValue());

        redPieces.stream()
                .filter(p -> p.isPlayed() == false )
                .forEach(p -> redPlayerPoints =+ p.getValue());

        if (redPlayerPoints < bluePlayerPoints){
            winner = "rouge";
        }
        else if (bluePlayerPoints < redPlayerPoints){
            winner = "bleu";
        }

        return new WinnerAndPoints(winner,redPlayerPoints,bluePlayerPoints);
    }
}
