package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class TodoItem implements Serializable {
    private int id;
    private String todoTitle;
    private String description;
    private LocalDateTime deadline;
    private boolean done;
    private AppUser assignee;


    public TodoItem(int id, String todoTitle, String description, LocalDateTime deadline, boolean done, AppUser assignee) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee = assignee;
    }

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public AppUser getAssignee() {
        return assignee;
    }

    public void setAssignee(AppUser assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() && isDone() == todoItem.isDone() && Objects.equals(getTodoTitle(), todoItem.getTodoTitle()) && Objects.equals(getDescription(), todoItem.getDescription()) && Objects.equals(getDeadline(), todoItem.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTodoTitle(), getDescription(), getDeadline(), isDone());
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", todoTitle='" + todoTitle + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
