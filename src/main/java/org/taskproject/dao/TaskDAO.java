package org.taskproject.dao;

import java.util.List;

import org.taskproject.model.Participant;
import org.taskproject.model.Task;
 
public interface TaskDAO {
 
    public void addTask(Task t);
    public void updateTask(Task t);
    public void removeTask(Task t);
    public List<Participant> listParticipantsInTask();
    public List<Task> listTasks();
}