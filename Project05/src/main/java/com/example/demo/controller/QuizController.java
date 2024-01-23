package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping("/q1")
    public void ex1(Model model){
        model.addAttribute("name", "둘리");
        model.addAttribute("age", "20");
        model.addAttribute("address", "인천 구월동");
    }

    @GetMapping("/q2")
    public void ex2(Model model){
        model.addAttribute("title", "스프링부트웹프로젝트");
        model.addAttribute("author", "구멍가게코딩단");
        model.addAttribute("publicationDate", LocalDate.of(2022,12,25));
    }
    
    @GetMapping("/q3")
    public void ex3(Model model){
        PersonDTO personDTO = new PersonDTO("둘리",20,"인천 구월동");
        model.addAttribute("dto", personDTO);
    }

	@GetMapping("/quiz4")
	public void quiz4(Model model) {
		List<BookDTO> list = new ArrayList<>();
		LocalDate date = LocalDate.of(2022, 12, 25);
		list.add(new BookDTO("스프링부트웹프로젝트","구멍가게코팅단",date));
		
		model.addAttribute("list",list);
	}

    @GetMapping("/quiz5")
    public void ex5(Model model){
    	int[] intArr = {1,2,3,4,5,6,7,8,9,10};
        model.addAttribute("arr", intArr);
    }

    @GetMapping("/quiz6")
    public void ex6(Model model){
        List<PersonDTO> dtoList = new ArrayList<>();
        dtoList.add(new PersonDTO("둘리",20,"인천 구월동"));
        dtoList.add(new PersonDTO("또치",30,"서울 신림동"));
        dtoList.add(new PersonDTO("도우너",40,"부산 문래동"));
        model.addAttribute("list", dtoList);
    }

    @GetMapping({"/quiz7","/quiz8"})
    public void ex7(Model model){
    	List<PersonDTO> list = new ArrayList<>();
    	list.add(new PersonDTO("박하나",25,"인천 구월동"));
    	list.add(new PersonDTO("홍재범",17,"서울 신림동"));
    	list.add(new PersonDTO("문유리",31,"부산 문래동"));
    	list.add(new PersonDTO("김재민",8,"인천 연수동"));
    	list.add(new PersonDTO("장유라",33,"부산 문래동"));
    	model.addAttribute("list",list);
    }
    
   
}









