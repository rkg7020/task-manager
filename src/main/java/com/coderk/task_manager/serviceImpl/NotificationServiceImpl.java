package com.coderk.task_manager.serviceImpl;

import com.coderk.task_manager.entity.Task;
import com.coderk.task_manager.repository.TaskRepository;
import com.coderk.task_manager.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Scheduled(cron = "0 0 8 * * ?") // Schedule to run every day at 8 AM
    public void sendReminders() {
        List<Task> tasks = taskRepository.findByDueDate(LocalDate.now().plusDays(1));
        for (Task task : tasks) {
            // Logic to send reminder (e.g., email, SMS)
            System.out.println("Reminder: Task '" + task.getTitle() + "' is due tomorrow.");
        }
    }
}
