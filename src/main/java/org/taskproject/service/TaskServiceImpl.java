package org.taskproject.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.taskproject.dao.TaskDAO;
import org.taskproject.model.Participant;
import org.taskproject.model.Task;

@Service
@ManagedBean(name="taskService")
@SessionScoped
public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDAO;
	 
    public void setTaskDAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }
 
    @Override
    @Transactional
    public void addTask(Task t) {
        this.taskDAO.addTask(t);
    }

    @Override
    @Transactional
    public void updateTask(Task t) {
        this.taskDAO.updateTask(t);
    }

    @Override
    @Transactional
    public void removeTask(Task t) {
        this.taskDAO.removeTask(t);
    }

    @Override
    @Transactional
    public List<Task> listTasks() {
        return this.taskDAO.listTasks();
    }

    @Override
    @Transactional
    public List<Participant> listParticipantsInTask() {
        return this.taskDAO.listParticipantsInTask();
    }
 
}
