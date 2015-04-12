package com.dukescript.todolist;

import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.ModelOperation;
import net.java.html.json.Property;


@Model(className = "TaskListViewModel", properties = {
    @Property(name = "input", type = String.class),
    @Property(name = "tasks", type = Task.class, array = true),
    @Property(name = "editing", type = Task.class)
}, targetId = "body")
final class TaskListViewModelDefinition {

    @Function
    public static void editTask(TaskListViewModel list, Task data) {
        list.setEditing(data);
    }

    @Function
    public static void stopEditing(TaskListViewModel list) {
        list.setEditing(null);
    }

    @Function
    @ModelOperation
    public static void deleteTask(TaskListViewModel model, Task data) {
        model.getTasks().remove(data);
    }

    @Function
    @ModelOperation
    public static void addTask(TaskListViewModel model) {
        if (null == model.getInput() || model.getInput().length() == 0) {
            return;
        }
        Task task = new Task(model.getInput(), false);
        model.setInput("");
        model.getTasks().add(task);
    }

}
