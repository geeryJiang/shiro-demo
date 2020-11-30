package com.test.shiro;

import com.test.shiro.dao.UsersMapper;
import com.test.shiro.entity.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
    SqlSession sqlSession;
	
	@Test
	public void testCRUD() {

        /*int insert = usersMapper.insert(new Users(null, "userName", "email", "password"));
        System.out.println(insert);*/

		/*UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insert(new Users(null, uid, "email", "password"));
		}
		System.out.println("批量处理完成");*/
		
	}

}
