package ac.ks.example;

import ac.ks.example.doamin.Basic;
import ac.ks.example.repository.BasicRepository;
import ac.ks.example.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository){
        return (args) -> IntStream.rangeClosed(1,4).forEach(index ->{
            basicRepository.save(Basic.builder().email("hong@gmail.com")
                    .label("도적")
                    .name("홍길동")
                    .phone("012-3456-789")
                    .build());
        });
    }
}
