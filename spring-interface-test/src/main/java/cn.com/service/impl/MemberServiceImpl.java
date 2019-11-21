package cn.com.service.impl;

import cn.com.bean.Member;
import cn.com.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * @author yulong
 * @create 2019/9/30
 */
@Service
public class MemberServiceImpl implements MemberService {


    @Override
    public void add(Member member) {

        System.out.println("会员服务-添加会员");

    }
}
