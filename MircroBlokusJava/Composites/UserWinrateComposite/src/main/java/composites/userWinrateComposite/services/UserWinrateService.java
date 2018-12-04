package composites.userWinrateComposite.services;

import composites.userWinrateComposite.clients.IUserClient;
import composites.userWinrateComposite.entities.User;
import composites.userWinrateComposite.entities.UserWithWinrate;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserWinrateService {

    @Setter
    private IUserClient iUserClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IUserClient.class, "http://localhost:3000/user/{username}");

    public UserWithWinrate returnUserWinrate(String username){
        log.info("call to the API for User - getOneById : "+username);
        User currentUser = iUserClient.getOneByUsername(username);

        double nmbWin = currentUser.getNumberOfWin();
        double nmbGames = currentUser.getNumberOfGames();

        double Userwinrate =  (double) 100*(nmbWin / nmbGames);

        UserWithWinrate finalUser = new UserWithWinrate(
                currentUser.getId(),
                currentUser.getUsername(),
                currentUser.getPassword(),
                currentUser.getEmail(),
                currentUser.getNumberOfWin(),
                currentUser.getNumberOfGames(),
                Userwinrate);

        return finalUser;
    }
}
