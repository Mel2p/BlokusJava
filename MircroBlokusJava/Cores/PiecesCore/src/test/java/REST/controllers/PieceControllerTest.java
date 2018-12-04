package REST.controllers;

import REST.entities.Piece;
import REST.repositories.PieceRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PieceControllerTest {

    @Mock
    PieceRepository pieceRepository;

    @Autowired
    @InjectMocks
    PieceController pieceController;

    @Autowired
    MockMvc mockMvc;

    private static String GETALL_CONTROLLER_RESPONSE = "[{\"id\":\"1\",\"value\":2,\"shape\":\"SHAPE\",\"played\":true}]";
    private static String GETONEBYID_CONTROLLER_REPONSE = "{\"id\":\"1\",\"value\":2,\"shape\":\"SHAPE\",\"played\":true}";

    private static List<Piece> GETALL_REPOSITORY_RESPONSE = new ArrayList<>();
    private static Piece GETONEBYID_REPOSITORY_RESPONSE = new Piece("1", 2,"SHAPE", true);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        GETALL_REPOSITORY_RESPONSE.add(new Piece("1",2,"SHAPE", true));
    }

    @Test
    public void getAll_should_return_valid_response() throws Exception{
        Mockito.when(pieceRepository.findAll()).thenReturn(GETALL_REPOSITORY_RESPONSE);
        this.mockMvc.perform(get("/pieces"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(GETALL_CONTROLLER_RESPONSE)));
    }

    @Test
    public void post_should_return_valid_object() throws Exception{
        Mockito.when(pieceRepository.findById("1")).thenReturn(Optional.of(GETONEBYID_REPOSITORY_RESPONSE));
        this.mockMvc.perform(get("/pieces/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(GETONEBYID_CONTROLLER_REPONSE)));

    }
}
