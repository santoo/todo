package com.santoo.todo.task;

import com.santoo.todo.category.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskRepository taskRepository;

    @RequestMapping(path = "/add",method = RequestMethod.PUT)
    public void addTask(String categoryId,String task){
        Task taskObj=new Task();
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        Category category=new Category(id,task);
        taskObj.setTaskId(id);
        taskObj.setTaskName(task);
        taskRepository.save(taskObj);
    }

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteTask(@PathParam("id") String id){
        taskRepository.deleteById(id);
    }

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<Task> getAllTask(){

        return taskRepository.findAll();
    }
}
