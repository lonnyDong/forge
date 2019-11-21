package cn.com.controller;

import cn.com.bean.Member;
import cn.com.service.ManageService;
import cn.com.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yulong
 * @create 2019/9/30
 */

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberServiceImpl;

    @Autowired
    private MemberService memberManagerImpl;

    @Autowired
    private ManageService manageServiceImpl;


    @GetMapping("/add/{name}")
    public String  add(@PathVariable String name ) {
        Member member = new Member();
        member.setName(name);

        memberServiceImpl.add(member);
        memberManagerImpl.add(member);

        manageServiceImpl.allocateBenefits(member);
        return "success";
    }


}
