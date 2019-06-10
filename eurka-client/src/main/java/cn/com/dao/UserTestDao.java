package cn.com.dao;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.springframework.stereotype.Component;

import cn.com.bean.User;
@Component
@DB(table= "t_user",name = "ds1")
public interface UserTestDao {
	
	
	@SQL("insert into #table(id, username, password, tradepwd,email,phone,name,id_no,status,remark"
			+ ",create_time,update_time) values(:id, :username, "
			+ ":password, :tradepwd,:email,:phone,:name,:idNo,:status,:remark,:createTime,:updateTime)")
	int addUser(User user);
	
//	@SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
//	int updateUserInfo();
	
	
//	@SQL("insert into #table(id, uid, price, status) values(:id, :uid, :price, :status)")
//	User getUserbyId(Long id);
	
}




