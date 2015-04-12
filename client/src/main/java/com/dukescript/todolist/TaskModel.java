package com.dukescript.todolist;

import net.java.html.json.Model;
import net.java.html.json.Property;

@Model(className = "Task", properties = {
    @Property(name = "title", type = String.class),
    @Property(name = "complete", type = boolean.class)})
final class TaskModel {
    
}
