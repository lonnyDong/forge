package cn.com.service;

import cn.com.bean.Member;

/**
 * @author yulong
 * @create 2019/9/30
 * 管理接口
 *
 *
 */
public interface ManageService {

    /**
     * 发放福利
     */
    void allocateBenefits(Member menber);

}
