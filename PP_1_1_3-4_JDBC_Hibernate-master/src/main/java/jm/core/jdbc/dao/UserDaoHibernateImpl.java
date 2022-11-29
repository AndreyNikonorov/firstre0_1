package jm.core.jdbc.dao;

import jm.core.jdbc.model.User;
import jm.core.jdbc.util.HiberUtil;
import org.hibernate.*;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = HiberUtil.buildSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS public.users" +
                    "(id SERIAL NOT NULL,  " +
                    "name VARCHAR(50)," +
                    "lastname VARCHAR(50)," +
                    "age smallint," +
                    "PRIMARY KEY (id))"
            ).executeUpdate();
            transaction.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }


    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.createSQLQuery("DROP TABLE IF EXISTS public.users").executeUpdate();
            transaction.commit();

        } catch(HibernateException e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
         Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }


    @Override
    public void removeUserById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.delete(session.get(User.class, id));
            transaction.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }


    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> userList = null;
        try (session) {
            userList = session.createQuery("FROM User", User.class).getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();

        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            session.createSQLQuery("TRUNCATE users").executeUpdate();
            transaction.commit();

        } catch(HibernateException e){
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        }
    }


}

