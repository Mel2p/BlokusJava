package composites.gameAndPlayersPiecesComposites.controllers;

import composites.gameAndPlayersPiecesComposites.entities.Game;
import composites.gameAndPlayersPiecesComposites.entities.GameAndPlayersPieces;
import composites.gameAndPlayersPiecesComposites.entities.Piece;
import composites.gameAndPlayersPiecesComposites.services.GameAndPlayersPiecesService;
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
public class GameAndPlayersPiecesControllerTest {

    @Mock
    GameAndPlayersPiecesService mockedService;

    @Autowired
    private GameAndPlayersPiecesController gameAndPlayersPiecesController;

    @Autowired
    MockMvc mockMvc;

    private static String CONTROLLER_RESPONSE = "{\"game\":{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":1,\"userId\":\"1\"},\"bluePlayersPieces\":[{\"id\":\"1\",\"value\":1,\"shape\":\"SHAPE\",\"played\":true}],\"redPlayersPieces\":[{\"id\":\"1\",\"value\":1,\"shape\":\"SHAPE\",\"played\":true}]}";

    private Game game = new Game("1", "BOARD",1,"1");

    private List<Piece> playersPieces = new ArrayList<>();

    GameAndPlayersPieces SERVICE_RESPONSE = new GameAndPlayersPieces(game, playersPieces, playersPieces);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        gameAndPlayersPiecesController.setGameAndPlayersPiecesService(mockedService);
        playersPieces.add(new Piece("1",1,"SHAPE", true));
    }

    @Test
    public void should_return_valid_response()throws Exception{
        Mockito.when(mockedService.gameAndPlayersPieces("1")).thenReturn(SERVICE_RESPONSE);
        this.mockMvc.perform(get("/game/finalobject/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }
}
