package org.taskproject.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@Entity
@Table(name ="PARTICIPANT")
@ManagedBean(name="participant")
public class Participant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}