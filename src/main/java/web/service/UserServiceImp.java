package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void save(User user) {
      userDao.save(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public User getUser(long id) {
      return userDao.getUser(id);
   }

   @Transactional
   @Override
   public void deleteUser(long id) {
      userDao.deleteUser(id);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }
}
