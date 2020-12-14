import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tuna.pojo.Employee;

public class MainApplicationTest {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    //资源初始化
    @Before
    public void init() {
        Configuration configure = new Configuration().configure();
        sessionFactory = configure.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    /**
     * hibernate stairCache Test
     * get: 即时加载    查询不到记录返回null
     * load: 延时检索   查询不到记录抛出异常
     * flush同步更新对象与数据库记录
     */
    @Test
    public void stairCacheTest() {

        //第一次查询
        Employee employee = session.get(Employee.class, 3);
        employee.setEmp_name("Java");


    }

    //资源销毁
    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
