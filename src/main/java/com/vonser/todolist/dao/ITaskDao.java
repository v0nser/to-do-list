package com.vonser.todolist.dao;

import org.springframework.stereotype.Component;

import com.vonser.todolist.models.Account;
import com.vonser.todolist.models.Task;

import java.util.List;
import java.util.Optional;

@Component
public interface ITaskDao {

    /**
     * is simply for adding task
     * @see com.vonser.todolist.controllers.DashboardController
     * @see com.vonser.todolist.controllers.api.TasksController
     * **/
    void add(Task task, Account account);

    /**
     * is for deleting task by id
     * @see com.vonser.todolist.controllers.AdminController
     * **/
    void deleteById(int id);

    /**
     * when we deleting a task we need to make sure that the task wanted to be deleted is actually belong to the user
     * wants to delete the task so we need to **get** the task and then check if it belong to the user
     * want to delete the task (for security purposes)
     * @see com.vonser.todolist.controllers.DashboardController
     * **/
    Optional<Task> getById(int id);

    /**
     * get all the tasks used in the api
     * @see com.vonser.todolist.controllers.api.TasksController
     * **/
    List<Task> getAll();

    /**
     * WARNING!!!!!!
     * @implNote USES ONLY IN INTEGRATION TESTING
     * **/
    void deleteAllInBatch();

    /**
     * to simply delete task
     * @see com.vonser.todolist.controllers.api.TasksController
     * @see com.vonser.todolist.controllers.DashboardController
     * **/
    void delete(Task task, Account account);

}
