package composites.gameAndPlayersPiecesComposites;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GameAndPlayersPiecesApplication {

    public static void main(String[] args) { SpringApplication.run(GameAndPlayersPiecesApplication.class, args); }
}
