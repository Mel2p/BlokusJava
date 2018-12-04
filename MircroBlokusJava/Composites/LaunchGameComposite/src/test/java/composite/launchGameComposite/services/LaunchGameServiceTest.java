package composite.launchGameComposite.services;

import composite.launchGameComposite.clients.IGameClient;
import composite.launchGameComposite.clients.IPieceClient;
import composite.launchGameComposite.entities.Game;
import composite.launchGameComposite.entities.GameAndAllPieces;
import composite.launchGameComposite.entities.Piece;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LaunchGameServiceTest {

    @Mock
    IGameClient mockedGameClient;

    @Mock
    IPieceClient mockedPieceClient;

    LaunchGameService launchGameService = new LaunchGameService();

    private Game GAME_CLIENT_RESPONSE = new Game("1", "BOARD", 1,"2");
    private List<Piece> PIECE_CLIENT_RESPONSE = new ArrayList<>();


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        launchGameService.setIGameClient(mockedGameClient);
        launchGameService.setIPieceClient(mockedPieceClient);
        PIECE_CLIENT_RESPONSE.add(new Piece("1", 4,"SHAPE",true));
        PIECE_CLIENT_RESPONSE.add(new Piece("2", 3,"SHAPE",false));
    }

    @Test
    public void should_create_the_right_newGame_object(){
        Mockito.when(mockedGameClient.getOneById("1")).thenReturn(GAME_CLIENT_RESPONSE);
        Mockito.when(mockedPieceClient.getAll()).thenReturn(PIECE_CLIENT_RESPONSE);
        GameAndAllPieces EXPECTED_RESULT = new GameAndAllPieces(GAME_CLIENT_RESPONSE, PIECE_CLIENT_RESPONSE);
        assertEquals("The GameAndAllPieces created by service should be the same as the expected result",
                EXPECTED_RESULT,launchGameService.returnNewGameWithAllPieces("1"));
    }

}
