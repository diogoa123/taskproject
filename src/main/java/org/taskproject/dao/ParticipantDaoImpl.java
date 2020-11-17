package org.taskproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.taskproject.model.Participant;

import java.util.List;

@Repository
public class ParticipantDaoImpl implements ParticipantDAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addParticipant(Participant p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updateParticipant(Participant p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(p);
    }

    @Override
    public void removeParticipant(Participant p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(p);
    }

    @Override
    public List<Participant> listParticipants() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Participant> participantsList = session.createQuery("from Participant").list();
        return participantsList;
    }
}
