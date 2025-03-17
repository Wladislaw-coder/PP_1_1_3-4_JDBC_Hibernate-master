package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser("Тим", "Бертон", (byte) 25);
        userDao.saveUser("Наталья", "Хельмерт", (byte) 22);
        userDao.saveUser("Владислав", "Хельмерт", (byte) 23);
        userDao.saveUser("Мия", "Хельмерт", (byte) 5);

        List<User> users = userDao.getAllUsers();
        users.forEach(System.out::println);

        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
