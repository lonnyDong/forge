package cn.com.service.impl;

import cn.com.bean.Member;
import cn.com.service.ManageService;
import cn.com.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * @author yulong
 * @create 2019/9/30
 */

@Service
public class MemberManagerImpl implements MemberService, ManageService {


    @Override
    public void allocateBenefits(Member menber) {
        System.out.println("会员管理-发放福利");
    }

    @Override
    public void add(Member member) {
        System.out.println("会员管理-添加会员");
    }
}
