package composites.userWinrateComposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserWinrateCompositeApplication {
    public static void main(String[] args) { SpringApplication.run(UserWinrateCompositeApplication.class, args); }
}
