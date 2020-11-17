package org.taskproject.dao;

import org.taskproject.model.Participant;

import java.util.List;

public interface ParticipantDAO {

    public void addParticipant(Participant p);
    public void updateParticipant(Participant p);
    public void removeParticipant(Participant p);
    public List<Participant> listParticipants();
}
