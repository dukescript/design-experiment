/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dukescript.todolist;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author antonepple
 */
public class TodoListTest {

    @Test
    public void testAddTask() {
        TaskListViewModel taskList = new TaskListViewModel();
        Assert.assertEquals(taskList.getTasks().size(), 0);
        taskList.setInput("Buy milk!");
        taskList.addTask();
        Assert.assertEquals(taskList.getTasks().size(), 1);
        Task task = taskList.getTasks().get(0);
        Assert.assertEquals(task.getTitle(), "Buy milk!");
    }

    @Test
    public void testDeleteTask() {
        TaskListViewModel taskList = new TaskListViewModel();
        taskList.getTasks().add(new Task("Buy milk!", false));
        Assert.assertEquals(taskList.getTasks().size(), 1);
        Task task = taskList.getTasks().get(0);
        taskList.deleteTask(task);
        Assert.assertEquals(taskList.getTasks().size(), 0);      
    }
}
