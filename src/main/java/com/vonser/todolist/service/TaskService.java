package com.vonser.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vonser.todolist.dao.ITaskDao;
import com.vonser.todolist.exceptions.UsernameNotFoundException;
import com.vonser.todolist.models.Account;
import com.vonser.todolist.models.Task;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final ITaskDao taskDao;

    @Autowired
    public TaskService(@Qualifier("taskRepository") ITaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public void add(Task task, Account account) {
        taskDao.add(task, account);
    }

    public void delete(Task task, Account account) {
        taskDao.delete(task, account);
    }

    public Task getById(int id) {
        return taskDao.getById(id).orElseThrow(UsernameNotFoundException::new);
    }

    public List<Task> getAll() {
        return taskDao.getAll();
    }

    public void deleteById(int id) {
        taskDao.deleteById(id);
    }

}
