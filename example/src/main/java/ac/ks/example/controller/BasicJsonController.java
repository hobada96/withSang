package ac.ks.example.controller;

import ac.ks.example.doamin.Basic;
import ac.ks.example.repository.BasicRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BasicJsonController {
    private BasicRepository basicRepository;

    public BasicJsonController(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    @GetMapping("/json/helloworld")
    public List<Basic> helloWolrd() {
        return basicRepository.findAll();
    }
}
