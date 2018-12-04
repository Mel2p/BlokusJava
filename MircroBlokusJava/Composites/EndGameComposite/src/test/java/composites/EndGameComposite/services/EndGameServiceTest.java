package composites.EndGameComposite.services;


import composites.EndGameComposite.clients.IGameAndPlayersPiecesClient;
import composites.EndGameComposite.entities.Game;
import composites.EndGameComposite.entities.GameAndPlayersPieces;
import composites.EndGameComposite.entities.Piece;
import composites.EndGameComposite.entities.WinnerAndPoints;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class EndGameServiceTest {

    @Mock
    IGameAndPlayersPiecesClient mockedClient;

    EndGameService endGameService = new EndGameService();

    private static Game game = new Game("1","BOARD", 1,"1");
    private static List<Piece> redplayersPieces = new ArrayList<>();
    private static List<Piece> blueplayersPieces = new ArrayList<>();

    private static GameAndPlayersPieces CLIENT_RESPONSE = new GameAndPlayersPieces(game, blueplayersPieces ,redplayersPieces);
    private static WinnerAndPoints EXPECTED_RESULT = new WinnerAndPoints("rouge",1,3);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        endGameService.setIGameAndPlayersPiecesClient(mockedClient);
        redplayersPieces.add(new Piece("1", 1,"SHAPE",false));
        blueplayersPieces.add(new Piece("1", 3,"SHAPE",false));
    }

    @Test
    public void should_return_right_winner(){
        Mockito.when(mockedClient.getOneById("1")).thenReturn(CLIENT_RESPONSE);
        assertEquals("redplayer should be the winner", EXPECTED_RESULT.getWinner(),
                endGameService.finalScore("1").getWinner());
        assertEquals("bluePlayerPoints should be 3", EXPECTED_RESULT.getBluePlayerPoints(),
                endGameService.finalScore("1").getBluePlayerPoints());
        assertEquals("redplayer should be 1", EXPECTED_RESULT.getRedPlayerPoints(),
                endGameService.finalScore("1").getRedPlayerPoints());
    }
}
