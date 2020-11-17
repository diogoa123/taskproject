package org.taskproject.cronjobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.taskproject.javamail.EmailUtil;
import org.taskproject.model.Participant;
import org.taskproject.model.Task;
import org.taskproject.service.TaskService;

import javax.mail.Session;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

@Component
public class ScheduleCron {

    @Autowired
    private TaskService taskService;

    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }


    //second, minute, hour, day of month, month, day(s) of week
    @Scheduled(cron = "0 0 7 * * *")
    public void alertTask() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentTime = formatter.format(LocalDate.now());
        for (Task task: taskService.listTasks()) {
            String taskBeginDate = formatter.format(task.getBeginDate());
            if(taskBeginDate.equals(currentTime)){
                Properties props = System.getProperties();

                props.put("mail.smtp.host", "smtp.example.com");

                Session session = Session.getInstance(props, null);
                for (Participant participant : task.getParticipantsList()) {
                    EmailUtil.sendEmail(session, participant.getEmail(), task.getTitle(), "Alert "+ task.getTitle() +" starting");
                }
            };
        }
    }
}
