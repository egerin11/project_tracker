package com.example.tracking_project.rep;

import com.example.tracking_project.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t JOIN t.assignedUsers u WHERE u.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") Long userId);
}
