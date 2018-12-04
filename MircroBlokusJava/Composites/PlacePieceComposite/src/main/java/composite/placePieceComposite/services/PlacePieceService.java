package composite.placePieceComposite.services;

import composite.placePieceComposite.clients.IGameAndPlayersPiecesClient;
import composite.placePieceComposite.entities.Game;
import composite.placePieceComposite.entities.GameAndPieces;
import composite.placePieceComposite.entities.GameAndPlayersPieces;
import composite.placePieceComposite.entities.Piece;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PlacePieceService {

    @Setter
    private IGameAndPlayersPiecesClient iGameAndPlayersPiecesClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameAndPlayersPiecesClient.class, "http://localhost:8047/game/finalobject/{id}");

    public GameAndPieces placePiece(String gameId, String pieceId){

        log.info("call to the GameAndPlayersPieces core - getOneById : "+gameId);
        GameAndPlayersPieces currentGameAndPlayersPieces = iGameAndPlayersPiecesClient.getOneById(gameId);

        Game currentGame = currentGameAndPlayersPieces.getGame();
        List<Piece> playerPieces = new ArrayList<>();

        if(currentGameAndPlayersPieces.getGame().getTurn() %2 == 1) {
            currentGameAndPlayersPieces.getBluePlayersPieces()
                    .stream()
                    .filter(p-> p.getId() == pieceId)
                    .forEach(p -> p.setPlayed(true));

            playerPieces = currentGameAndPlayersPieces.getRedPlayersPieces();
        }
        else if (currentGameAndPlayersPieces.getGame().getTurn() %2 == 0){
            currentGameAndPlayersPieces.getRedPlayersPieces()
                    .stream()
                    .filter(p-> p.getId() == pieceId)
                    .forEach(p-> p.setPlayed(true));

            playerPieces = currentGameAndPlayersPieces.getBluePlayersPieces();
        }

        log.info("Check player pieces " + playerPieces);
        return new GameAndPieces(currentGame, playerPieces);
    }



}
