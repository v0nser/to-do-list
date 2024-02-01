package com.vonser.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vonser.todolist.models.Account;
import com.vonser.todolist.models.Task;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>, ITaskDao {

    @Override
    default void delete(Task task, Account account) {
        account.removeTask(task);
    }

    @Override
    default void add(Task task, Account account) {
        account.addTask(task);
    }

    @Override
    default Optional<Task> getById(int id) {
        return findById(id);
    }

    @Override
    default List<Task> getAll() {
        return findAll();
    }

    @Query(value = "DELETE FROM tasks WHERE tasks.id = ?1", nativeQuery = true)
    @Transactional
    @Modifying
    @Override
    void deleteById(int id);

}
