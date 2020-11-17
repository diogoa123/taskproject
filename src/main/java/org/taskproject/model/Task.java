package org.taskproject.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="TASK")
@ManagedBean(name="task")
public class Task {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
     
    private String title;

    private Date beginDate;

    private Date endDate;

    @ManyToMany(mappedBy = "participants")
    private List<Participant> participantsList;

    public List<Participant> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(List<Participant> participantsList) {
        this.participantsList = participantsList;
    }

    public int getId() {
        return id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", participantsList=" + participantsList +
                '}';
    }
}