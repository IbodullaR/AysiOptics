package uz.kuponbot.kupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KuponApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuponApplication.class, args);
    }

}
