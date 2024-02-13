package tasks.service;

import tasks.entity.TaskEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static List<TaskEntity> tasks = new ArrayList<>();
    private static Long id = 5L;

    static{
        tasks.add(new TaskEntity(1L, "Создать веб приложение на Java EE", "Нужно создать приложение на Java EE", LocalDate.of(2021, 11, 3)));
        tasks.add(new TaskEntity(2L, "Вынести мусор и сделать домашку", "Уборка и дела", LocalDate.of(2022, 3, 30)));
        tasks.add(new TaskEntity(3L, "Сделать спринт таск 1 по Java EE", "Sprint task 1", LocalDate.of(2022, 10, 14)));
        tasks.add(new TaskEntity(4L, "Стать Java-разработчиком", "Java Junior Developer", LocalDate.of(2024, 5, 20)));
    }

    public static void create(TaskEntity newTask){
        newTask.setId(id++);
        tasks.add(newTask);
    }

    public static void update(Long id, TaskEntity task){
        for(TaskEntity entity: tasks){
            if(id.equals(entity.getId())){
                entity.setName(task.getName());
                entity.setDescription(task.getDescription());
                entity.setDeadLineDate(task.getDeadLineDate());
                entity.setDone(task.isDone());
                return;
            }
        }
        throw new RuntimeException("Task not found with id: " + id);
    }

    public static List<TaskEntity> findAll(){
        return tasks;
    }

    public static TaskEntity findById(Long id){
        for(TaskEntity task: tasks){
            if(id.equals(task.getId())){
                return task;
            }
        }
        throw new RuntimeException("Task not found with id: {}" + id);
    }

    public static void delete(Long id){
        tasks.removeIf(task -> id.equals(task.getId()));
    }



}
