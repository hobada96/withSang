package com.n2015942034.main.controller;

import com.n2015942034.main.domain.Basic;
import com.n2015942034.main.service.BasicService;
import com.n2015942034.main.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private BasicService basicService;
    private ProfileService profileService;

    public MainController(BasicService basicService, ProfileService profileService){
        this.profileService = profileService;
        this.basicService = basicService;
    }

    @GetMapping({"/","basic/list","profile/list"})
    public String list(Model model){
        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "main/index";
    }

    @PostMapping("/basic/add")
    public String add(Basic basic, Model model){
        Basic saveBasic = basicService.saveBasic(basic);
        model.addAttribute("basic",basicService.findBasicByIdx(saveBasic.getIdx()));
        return "/main/basic";
    }

    @GetMapping("new")
    public String form(Basic basic){
        return "/main/new";
    }

    @GetMapping("/basic/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("basic",basicService.findBasicByIdx(idx));
        return "/main/basic/item";
    }

    @DeleteMapping("/basic/{idx}")
    public ResponseEntity<?> delete(@PathVariable("idx")Long idx){
        basicService.deleteBasic(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PutMapping("/basic/{idx}")
    public ResponseEntity<?> update(@PathVariable("idx")Long idx, @RequestBody Basic basic){
        Basic persistBasic = basicService.getOne(idx);
        persistBasic.update(basic);
        basicService.saveBasic(persistBasic);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }

}
