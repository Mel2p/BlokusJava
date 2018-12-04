package composites.gameAndPlayersPiecesComposites.services;

import composites.gameAndPlayersPiecesComposites.clients.IGameClient;
import composites.gameAndPlayersPiecesComposites.clients.IPieceClient;
import composites.gameAndPlayersPiecesComposites.entities.Game;
import composites.gameAndPlayersPiecesComposites.entities.GameAndPlayersPieces;
import composites.gameAndPlayersPiecesComposites.entities.Piece;
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
public class GameAndPlayersPiecesService {

    @Setter
    private IGameClient iGameClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameClient.class, "http://localhost:8021/game/{id}");

    @Setter
    private IPieceClient iPieceClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IPieceClient.class, "http://localhost:8022/piece");

    public GameAndPlayersPieces gameAndPlayersPieces(String gameId){
        log.info("call to Game core - getOneById : " + gameId);
        Game currentGame= iGameClient.getOneById(gameId);
        List<Piece> bluePlayerPieces = iPieceClient.getAll();
        List<Piece> redPlayerPieces = iPieceClient.getAll();
        return new GameAndPlayersPieces(currentGame, bluePlayerPieces, redPlayerPieces);
    }


}
