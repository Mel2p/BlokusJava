package composites.gameAndPlayersPiecesComposites.services;

import composites.gameAndPlayersPiecesComposites.clients.IGameClient;
import composites.gameAndPlayersPiecesComposites.clients.IPieceClient;
import composites.gameAndPlayersPiecesComposites.entities.Game;
import composites.gameAndPlayersPiecesComposites.entities.GameAndPlayersPieces;
import composites.gameAndPlayersPiecesComposites.entities.Piece;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class GameAndPlayerPiecesServiceTest {

    @Mock
    IGameClient mockedGameClient;

    @Mock
    IPieceClient mockedPieceClient;

    GameAndPlayersPiecesService gameAndPlayersPiecesService = new GameAndPlayersPiecesService();

    private Game GAME_CLIENT_RESPONSE = new Game("1", "BOARD",1,"1");

    private List<Piece> PIECE_CLIENT_RESPONSE = new ArrayList<>();


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        gameAndPlayersPiecesService.setIGameClient(mockedGameClient);
        gameAndPlayersPiecesService.setIPieceClient(mockedPieceClient);
        PIECE_CLIENT_RESPONSE.add(new Piece("1",1,"SHAPE", true));
    }

    @Test
    public void should_create_correct_gameAndPlayersPieces_object(){
        Mockito.when(mockedGameClient.getOneById("1")).thenReturn(GAME_CLIENT_RESPONSE);
        Mockito.when(mockedPieceClient.getAll()).thenReturn(PIECE_CLIENT_RESPONSE);

        GameAndPlayersPieces EXPECTED_RESULT = new GameAndPlayersPieces(GAME_CLIENT_RESPONSE, PIECE_CLIENT_RESPONSE, PIECE_CLIENT_RESPONSE);

        assertEquals("EXPECTED_RESULT should be the same as return object by the service",
                EXPECTED_RESULT, gameAndPlayersPiecesService.gameAndPlayersPieces("1"));
    }

}
