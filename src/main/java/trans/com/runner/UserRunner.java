package trans.com.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import trans.com.model.User;
import trans.com.sevices.UserService;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        try {
            User user1 = new User("test", "Ops", 12000L);
            User user2 = new User("tes", "Tech", 22000L);
            userService.insert(Arrays.asList(
                    user1, user2
            ));
        }
        catch (RuntimeException exception) {
            System.out.println("Exception in batch 1...!" + exception.getMessage());
        }


        try {
            User user3 = new User("rati bhan", "Tech", 32000L);
            User user4 = new User("tty", "Ops", 18000L);
            userService.insert(Arrays.asList(
                    user3, user4
            ));
        }
        catch (RuntimeException exception) {
            System.out.println("Exception in batch 2...!" + exception.getMessage());
        }
        System.out.println(userService.getUsers());
    }
}
