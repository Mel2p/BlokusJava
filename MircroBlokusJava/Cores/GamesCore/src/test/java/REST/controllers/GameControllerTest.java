package REST.controllers;

import REST.entities.Game;
import REST.repositories.GameRepository;
import REST.services.NextTurnService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Mock
    GameRepository gameRepository;

    @Mock
    NextTurnService nextTurnService;

    @Autowired
    @InjectMocks
    GameController gameController;

    @Autowired
    MockMvc mockMvc;

    private static String GETALL_CONTROLLER_RESPONSE = "[{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":1,\"userId\":\"1\"}]";
    private static String POST_CONTROLLER_RESPONSE = "{\"id\":null,\"currentBoard\":\"[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,]\",\"turn\":0,\"userId\":\"1\"}";
    private static String GETONEBYID_CONTROLLER_REPONSE = "{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":1,\"userId\":\"1\"}";
    private static String NEXT_TURN_CONTROLLER_RESPONSE = "{\"id\":\"1\",\"currentBoard\":\"BOARD\",\"turn\":1,\"userId\":\"1\"}";

    private static List<Game> GETALL_REPOSITORY_RESPONSE = new ArrayList<>();
    private static Game POST_REPOSITORY_RESPONSE = new Game("[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,]",0,"1");
    private static Game GETONEBYID_REPOSITORY_RESPONSE = new Game("1", "BOARD", 1, "1");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        GETALL_REPOSITORY_RESPONSE.add(new Game("1","BOARD", 1, "1"));
    }


    @Test
    public void getAll_should_return_valid_response() throws Exception {
        Mockito.when(gameRepository.findAll()).thenReturn(GETALL_REPOSITORY_RESPONSE);
        this.mockMvc.perform(get("/games"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(GETALL_CONTROLLER_RESPONSE)));
    }

    @Test
    public void post_should_return_valid_object() throws Exception {
        Mockito.when(gameRepository.save(new Game("[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,]",0,"1")))
                .thenReturn(POST_REPOSITORY_RESPONSE);
        this.mockMvc.perform(post("/games/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(POST_CONTROLLER_RESPONSE)));
    }

    @Test
    public void getOneById_should_return_valid_response()throws  Exception{
        Mockito.when(gameRepository.findById("1")).thenReturn(Optional.of(GETONEBYID_REPOSITORY_RESPONSE));
        this.mockMvc.perform(get("/games/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(GETONEBYID_CONTROLLER_REPONSE)));
    }

    @Test
    public void nextTurn_should_return_valid_response()throws Exception{
        Mockito.when(nextTurnService.nextTurn("1")).thenReturn(GETONEBYID_REPOSITORY_RESPONSE);
        this.mockMvc.perform(get("/games/1/next_turn"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(NEXT_TURN_CONTROLLER_RESPONSE)));
    }
}
