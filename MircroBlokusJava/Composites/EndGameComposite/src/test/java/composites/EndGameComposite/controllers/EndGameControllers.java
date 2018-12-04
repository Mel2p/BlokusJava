package composites.EndGameComposite.controllers;

import composites.EndGameComposite.entities.WinnerAndPoints;
import composites.EndGameComposite.services.EndGameService;
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

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EndGameControllers {

    @Mock
    EndGameService endGameService;

    @Autowired
    private EndGameController endGameController;

    @Autowired
    private MockMvc mockMvc;

    private static String CONTROLLER_RESPONSE = "{\"winner\":\"rouge\",\"redPlayerPoints\":1,\"bluePlayerPoints\":4}";

    private WinnerAndPoints SERVICE_RESPONSE = new WinnerAndPoints("rouge",1,4);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        endGameController.setEndGameService(endGameService);
    }

    @Test
    public void should_return_valid_response()throws Exception{
        Mockito.when(endGameService.finalScore("1")).thenReturn(SERVICE_RESPONSE);
        this.mockMvc.perform(get("/game/1/end"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }
}
