package com.satya;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTaskRepository implements FileRepository {

    private  static final String TASKS_JSON_FILE="/home/satyasais/IdeaProjects/task-cosole/src/com/satya/abc.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    List<Task> tasks;
    File file=new File(TASKS_JSON_FILE);

    public FileTaskRepository() {
        tasks=readFromFile();
    }

    private void writeToFile(List<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE), tasks);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Task> readFromFile() {
        final File file = new File(TASKS_JSON_FILE);
        if (file.exists()) {
            try {
                return (List<Task>) objectMapper.readValue(file, TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        writeToFile(tasks);

    }

    @Override
    public List<Task> display() {
        return readFromFile();
    }

    @Override
    public ArrayList search(int input) {
      ArrayList list =new ArrayList();
       for (Task task:tasks)
       {
           if(task.getTaskId()==input)
           {
               list=task;

               return list;
           }
       }
        return null;
    }

    @Override
    public void delete(String input) {
     tasks.remove(input);
     writeToFile(tasks);
    }

    @Override
    public Task filter(Status status) {
        return null;
    }


}
