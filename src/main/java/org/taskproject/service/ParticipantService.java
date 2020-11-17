package org.taskproject.service;

import org.taskproject.model.Participant;

import java.util.List;

public interface ParticipantService {

    public void addParticipant(Participant p);
    public void updateParticipant(Participant p);
    public void removeParticipant(Participant p);
    public List<Participant> listParticipants();
}
