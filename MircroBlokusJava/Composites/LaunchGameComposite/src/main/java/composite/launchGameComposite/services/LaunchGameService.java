package composite.launchGameComposite.services;

import composite.launchGameComposite.clients.IGameClient;
import composite.launchGameComposite.clients.IPieceClient;
import composite.launchGameComposite.entities.Game;
import composite.launchGameComposite.entities.GameAndAllPieces;
import composite.launchGameComposite.entities.Piece;
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
public class LaunchGameService {

    @Setter
    private IGameClient iGameClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGameClient.class, "http://localhost:8021/");

    @Setter
    private IPieceClient iPieceClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IPieceClient.class, "http://localhost:8022/");

    public GameAndAllPieces returnNewGameWithAllPieces(String gameId){

        log.info("call to the Game core - getOneById : "+gameId);
        Game currentGame = iGameClient.getOneById(gameId);
        log.info("call to the Piece core - getAll");
        List<Piece> allPieces = iPieceClient.getAll();
        GameAndAllPieces gameAndAllPieces = new GameAndAllPieces(currentGame.getId(),currentGame.getCurrentBoard(),currentGame.getTurn(),currentGame.getUserId(), allPieces);
        log.info("new Game = "+ gameAndAllPieces);
        return gameAndAllPieces;
    }
}
