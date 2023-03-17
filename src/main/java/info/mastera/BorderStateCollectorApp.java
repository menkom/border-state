package info.mastera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BorderStateCollectorApp {
    public static void main(String[] args) {
        SpringApplication.run(BorderStateCollectorApp.class, args);
    }
}
