package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    //透過 @RequestMapping 指定從/會被對應到此addMemberPage()方法
//	@Autowired
//	MemberAccount memberAccount;
//
//	@Autowired
//	MemberService memberService;
//
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DataSource dataSource;

    @GetMapping("/addMemberPage")
    public String addMemberPage(){

        List<MemberAccountJPA> memberAccountJPA= new ArrayList<MemberAccountJPA>();
        memberAccountJPA = memberRepository.findAll();

        for(int i=0;i<memberAccountJPA.size();i++){
            System.out.println(memberAccountJPA.get(i).getId());
        }
        return "addMemberPage";
    }
}
