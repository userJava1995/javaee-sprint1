package tasks.entity;

import java.time.LocalDate;

public class TaskEntity {
    private Long id;
    private String name;
    private String description;

    private LocalDate deadLineDate;

    private boolean isDone = false;

    public TaskEntity(){

    }



    public TaskEntity(Long id, String name, String description, LocalDate deadLineDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadLineDate = deadLineDate;
    }

    public TaskEntity(String name, String description, LocalDate deadLineDate) {
        this.name = name;
        this.description = description;
        this.deadLineDate = deadLineDate;
    }

    public TaskEntity(String name, String description, LocalDate deadLineDate, boolean isDone) {
        this.name = name;
        this.description = description;
        this.deadLineDate = deadLineDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(LocalDate deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
