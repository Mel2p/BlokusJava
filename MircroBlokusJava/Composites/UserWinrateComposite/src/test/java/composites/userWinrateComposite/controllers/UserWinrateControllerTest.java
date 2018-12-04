package composites.userWinrateComposite.controllers;

import composites.userWinrateComposite.entities.User;
import composites.userWinrateComposite.entities.UserWithWinrate;
import composites.userWinrateComposite.services.UserWinrateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class UserWinrateControllerTest {

    @Mock
    UserWinrateService mockedService;

    @Autowired
    UserWinrateController userWinrateController;

    @Autowired
    MockMvc mockMvc;

    private static String CONTROLLER_RESPONSE = "{\"id\":\"1\",\"username\":\"Username\",\"password\":\"Password\",\"email\":\"Email\",\"numberOfWin\":5,\"numberOfGames\":10,\"winrate\":50.0}";

    private UserWithWinrate SERVICE_RESPONSE = new UserWithWinrate("1","Username","Password","Email", 5, 10, 50.0);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userWinrateController.setUserWinrateService(mockedService);
    }

    @Test
    public void should_return_valid_response()throws Exception{
        Mockito.when(mockedService.returnUserWinrate("1")).thenReturn(SERVICE_RESPONSE);
        this.mockMvc.perform(get("/user/1/winrate"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(CONTROLLER_RESPONSE)));
    }
}
