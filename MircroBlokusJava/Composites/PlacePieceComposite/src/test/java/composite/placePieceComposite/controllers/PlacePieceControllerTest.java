package composite.placePieceComposite.controllers;

import composite.placePieceComposite.entities.Game;
import composite.placePieceComposite.entities.GameAndPieces;
import composite.placePieceComposite.entities.GameAndPlayersPieces;
import composite.placePieceComposite.entities.Piece;
import composite.placePieceComposite.services.PlacePieceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlacePieceControllerTest {

    @Mock
    PlacePieceService mockedService;

    @Autowired
    private PlacePieceController placePieceController;

    @Autowired
    private MockMvc mockMvc;

    private static String CONTROLLER_RESPONSE = "{\"game\":{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":2,\"userId\":\"2\"},\"allPieces\":[]}";

    private List<Piece> result_idPiecePlayedByRedPlayer = new ArrayList<>();
    private List<Piece> result_idPiecePlayedByBluePlayer  = new ArrayList<>();
    private List<Piece> playedPieces = new ArrayList<>();
    private Game game = new Game("1","BOARD",2,"2");
    private Piece piece1 = new Piece("1",3,"SHAPE", true);
    private Piece piece2 = new Piece("1",3,"SHAPE", false);

    private GameAndPieces SERVICE_RESPONSE = new GameAndPieces(game, playedPieces);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        placePieceController.setPlacePieceService(mockedService);
    }

    @Test
    public void should_return_valid_response()throws Exception{
        Mockito.when(mockedService.placePiece("1","1")).thenReturn(SERVICE_RESPONSE);
        result_idPiecePlayedByBluePlayer.add(piece1);
        result_idPiecePlayedByRedPlayer.add(piece2);
        this.mockMvc.perform(get("/game/1/1/place_piece"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }

}
