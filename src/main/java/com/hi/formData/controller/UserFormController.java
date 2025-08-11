package com.hi.formData.controller;

import com.hi.formData.dto.FormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserFormController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("dto",
                new FormDto());
        return "form";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute("dto") FormDto dto,
                       Model model) {
        for (String x : dto.getHobbies()) {
            System.out.println(x);
        }
        model.addAttribute("dto", dto);
        return "result";
    }

    // 메서드에 정의된 @ModelAttribute는
    // form html 호출할 때 같이 데이터를 보낼 때 사용
    @ModelAttribute("hobbies")
    private Map<String, String> favorite() {
        Map<String, String> map = new HashMap<>();
        map.put("movie", "영화보기");
        map.put("music", "음악듣기");
        map.put("running", "러닝하기");
        map.put("game", "게임하기");
        return map;
    }





    @GetMapping("getName")
    public String getName(@RequestParam("name") String name) {
        System.out.println("getName = " + name);
        return "redirect:/form";
    }

    @PostMapping("getName")
    public String postName(FormDto dto) {
        System.out.println("postName = " + dto.getName());
        return "redirect:/form";
    }

    @GetMapping("/form2")
//    th:field가 있는 GetMapping은 껍데기 DTO를 보내야한다.
    public String showForm2(Model model) {
        model.addAttribute("dto", new FormDto());
        return "form2";
    }

    @PostMapping("/form2")
    public String postForm2(@ModelAttribute("dto") FormDto dto) {
        System.out.println(dto.getName());
        System.out.println(dto.getAge());
        return null;
    }
}