package composite.placePieceComposite.services;

import composite.placePieceComposite.clients.IGameAndPlayersPiecesClient;
import composite.placePieceComposite.entities.Game;
import composite.placePieceComposite.entities.GameAndPieces;
import composite.placePieceComposite.entities.GameAndPlayersPieces;
import composite.placePieceComposite.entities.Piece;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

public class PlacePieceServiceTest {

    private static List<Piece> client_piecePlayedByBluePlayer = new ArrayList<>();
    private static List<Piece> result_PiecePlayedByRedPlayer = new ArrayList<>();
    private static List<Piece> result_PiecePlayedByBluePlayer  = new ArrayList<>();

    @Mock
    IGameAndPlayersPiecesClient mockedClient;

    PlacePieceService placePieceService = new PlacePieceService();

    private static Game game = new Game("1","BOARD", 1,"1");
    private List<Piece> playersPieces = new ArrayList<>();

    private GameAndPlayersPieces CLIENT_RESPONSE = new GameAndPlayersPieces(game, playersPieces,playersPieces );

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        placePieceService.setIGameAndPlayersPiecesClient(mockedClient);
    }

    @Test
    public void should_change_playedValue_for_the_good_piece_in_the_good_list(){
        Piece current_piece = new Piece("1", 2, "SHAPE", false);
        Piece final_piece = new Piece("1", 2, "SHAPE", true);
        client_piecePlayedByBluePlayer.add(current_piece);
        result_PiecePlayedByBluePlayer.add(final_piece);
        Mockito.when(mockedClient.getOneById("1")).thenReturn(CLIENT_RESPONSE);

        Game EXPECTED_GAME = new Game("1", "BOARD", 1,"1");

        GameAndPieces ACTUAL_GAME = placePieceService.placePiece("1","1");
        GameAndPieces EXPECTED_RESULT = new GameAndPieces(EXPECTED_GAME, result_PiecePlayedByRedPlayer);

        assertEquals("result_PlayedPieceByBluePlayer should have a piece with played set as true"
                ,EXPECTED_RESULT.getAllPieces(),
                ACTUAL_GAME.getAllPieces());

    }

}
