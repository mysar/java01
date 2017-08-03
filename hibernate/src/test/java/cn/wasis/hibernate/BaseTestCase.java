package cn.wasis.hibernate;

import cn.wasis.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

public class BaseTestCase {

    protected Session session;

    @Before
    public void before() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }
}
