

import io.zhpooer.ssh.domain.User;
import io.zhpooer.ssh.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserServiceTest {
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    
    @Test
    public void testSaveUser(){
        User user = userService.login("fuck you");
        System.out.println("good !!!!!!!!!!!!!!!!");
    }
    
}
