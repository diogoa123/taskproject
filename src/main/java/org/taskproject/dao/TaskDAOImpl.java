package org.taskproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import org.taskproject.model.Participant;
import org.taskproject.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO{
	 
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addTask(Task t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(t);
    }

    @Override
    public void updateTask(Task t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(t);
    }

    @Override
    public void removeTask(Task t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(t);
    }

    @Override
    public List<Participant> listParticipantsInTask() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Participant> participantsInTaskList = session.createQuery("SELECT participants FROM Task").list();
        return participantsInTaskList;
    }

    @Override
    public List<Task> listTasks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> tasksList = session.createQuery("from Task").list();
        return tasksList;
    }
 
}
