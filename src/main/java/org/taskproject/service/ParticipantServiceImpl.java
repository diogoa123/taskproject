package org.taskproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taskproject.dao.ParticipantDAO;
import org.taskproject.model.Participant;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Service
@ManagedBean(name="participantService")
@SessionScoped
public class ParticipantServiceImpl implements ParticipantService{
    private ParticipantDAO participantDAO;

    public void setParticipantDAO(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    @Transactional
    public void addParticipant(Participant t) {
        this.participantDAO.addParticipant(t);
    }

    @Override
    @Transactional
    public void updateParticipant(Participant t) {
        this.participantDAO.updateParticipant(t);
    }

    @Override
    @Transactional
    public void removeParticipant(Participant t) {
        this.participantDAO.removeParticipant(t);
    }

    @Override
    @Transactional
    public List<Participant> listParticipants() {
        return this.participantDAO.listParticipants();
    }

}
