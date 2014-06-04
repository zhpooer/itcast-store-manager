import io.zhpooer.store.dao.UserinfoDao;
import io.zhpooer.store.domain.Userinfo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserinfoDaoTest {
    @Resource(name="userinfoDao") 
    private UserinfoDao userinfoDao;
    @Resource(name="hibernateTemplate")
    private HibernateTemplate template;
    
    @Test
    public void testIt(){
        Userinfo uinfo = new Userinfo();
        uinfo.setName("poe");
        uinfo.setPassword("123");
        template.save(uinfo);
    }
    
}
