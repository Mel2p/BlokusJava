package composite.launchGameComposite.controllers;

import composite.launchGameComposite.entities.Game;
import composite.launchGameComposite.entities.GameAndAllPieces;
import composite.launchGameComposite.entities.Piece;
import composite.launchGameComposite.services.LaunchGameService;
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
public class LaunchGameControllerTest {

    @Mock
    LaunchGameService mockedService;

    @Autowired
    private LaunchGameController launchGameController;

    @Autowired
    private MockMvc mockMvc;

    private static String CONTROLLER_RESPONSE = "{\"game\":{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":2,\"userId\":\"2\"},\"allPieces\":[{\"id\":\"1\",\"value\":4,\"shape\":\"SHAPE\",\"played\":true},{\"id\":\"2\",\"value\":3,\"shape\":\"SHAPE\",\"played\":false}]}";

    private Game GAME_CLIENT_RESPONSE = new Game("1", "BOARD", 2,"2");
    private List<Piece> PIECE_CLIENT_RESPONSE = new ArrayList<>();

    private GameAndAllPieces SERVICE_RESPONSE = new GameAndAllPieces(GAME_CLIENT_RESPONSE,PIECE_CLIENT_RESPONSE);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        launchGameController.setLaunchGameService(mockedService);
        PIECE_CLIENT_RESPONSE.add(new Piece("1", 4,"SHAPE",true));
        PIECE_CLIENT_RESPONSE.add(new Piece("2", 3,"SHAPE",false));
    }

    @Test
    public void should_return_valid_response()throws Exception{
        Mockito.when(mockedService.returnNewGameWithAllPieces("1")).thenReturn(SERVICE_RESPONSE);
        this.mockMvc.perform(get("/game/new/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }

}
