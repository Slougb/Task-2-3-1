package web.dao;

import web.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void save(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(long id) {
      User user = entityManager.find(User.class, id);
      return user;
   }

   @Override
   public void deleteUser(long id) {
      User user = entityManager.find(User.class, id);
      entityManager.remove(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      List<User> users = entityManager.createQuery("from User").getResultList();
      return users;
   }



}
