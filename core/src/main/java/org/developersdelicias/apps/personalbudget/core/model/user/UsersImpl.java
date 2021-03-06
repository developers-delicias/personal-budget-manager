package org.developersdelicias.apps.personalbudget.core.model.user;

import org.developersdelicias.apps.personalbudget.core.model.user.exceptions.UserNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Objects.isNull;

@Repository
public class UsersImpl implements Users {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return session().createQuery("from User").list();
    }

    @Override
    public void add(User newUser) {
        session().persist(newUser);
    }

    @Override
    public void update(User user) {
        Session session = session();
        session.update(user);
        session.flush();
    }

    @Override
    public void remove(long id) {
        Session session = session();
        session.createQuery("DELETE FROM User u WHERE u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        session.flush();
    }

    @Override
    public User findById(long id) {
        User user = session().get(User.class, id);
        validate(user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        List<User> list = session().createQuery("FROM User u WHERE u.username=:username")
                .setParameter("username", username)
                .list();
        validateIsNotEmpty(list);
        return list.get(0);
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    private void validateIsNotEmpty(List<User> list) {
        if (list.isEmpty()) {
            throw new UserNotFoundException();
        }
    }

    private void validate(User user) {
        if (isNull(user)) {
            throw new UserNotFoundException();
        }
    }
}
