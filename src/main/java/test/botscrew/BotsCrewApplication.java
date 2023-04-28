package test.botscrew;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.botscrew.ustils.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@Slf4j
public class BotsCrewApplication implements CommandLineRunner {
    @Autowired
    private CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        showInterface();
        while (!command.equals("!q")) {
            command = String.valueOf(reader.readLine());
            System.out.println(commandHandler.handle(command));
        }
    }

    private void showInterface() {
        System.out.println("###############################COMMANDS###############################");
        System.out.println("#   Who is head of department {department_name}                      #");
        System.out.println("#   Show the average salary for the department {department_name}     #");
        System.out.println("#   Show count of employee for {department_name}                     #");
        System.out.println("#   Show {department_name} statistics                                #");
        System.out.println("#   Global search by {template}                                      #");
        System.out.println("#   !q - to exit                                                     #");
        System.out.println("######################################################################");
    }
}
