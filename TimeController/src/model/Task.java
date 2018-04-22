/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author tuandung
 */
public class Task {
    int TaskId;
    String Taskname;
    Date DateCreate;
    Date DateDeadline;
    String Typetask;
    int Priority;
    String Description;

    public Task() {
    }

    public Task(int TaskId, String Taskname, Date DateCreate, Date DateDeadline, String Typetask, int Priority, String Description) {
        this.TaskId = TaskId;
        this.Taskname = Taskname;
        this.DateCreate = DateCreate;
        this.DateDeadline = DateDeadline;
        this.Typetask = Typetask;
        this.Priority = Priority;
        this.Description = Description;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public String getTaskname() {
        return Taskname;
    }

    public void setTaskname(String Taskname) {
        this.Taskname = Taskname;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public Date getDateDeadline() {
        return DateDeadline;
    }

    public void setDateDeadline(Date DateDeadline) {
        this.DateDeadline = DateDeadline;
    }

    public String getTypetask() {
        return Typetask;
    }

    public void setTypetask(String Typetask) {
        this.Typetask = Typetask;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
