package composites.userWinrateComposite.services;

import composites.userWinrateComposite.clients.IUserClient;
import composites.userWinrateComposite.entities.User;
import composites.userWinrateComposite.entities.UserWithWinrate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

public class UserWinrateServiceTest {

    @Mock
    IUserClient mockedClient;

    UserWinrateService userWinrateService = new UserWinrateService();

    private static User CLIENT_RESPONSE = new User("1","Username","Password", "email",5,10);

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userWinrateService.setIUserClient(mockedClient);
    }

    @Test
    public void should_return_user_with_the_good_winrate(){
        Mockito.when(mockedClient.getOneById("1")).thenReturn(CLIENT_RESPONSE);
        UserWithWinrate EXPECTED_RESULT = new UserWithWinrate("1","Username","Password", "email",5,10,50);
        assertEquals("The winrate should be 50",EXPECTED_RESULT, userWinrateService.returnUserWinrate("1"));
    }


}
