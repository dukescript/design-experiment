package com.dukescript.todolist;

import com.dukescript.todolist.js.StorageManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.html.BrwsrCtx;
import net.java.html.boot.BrowserBuilder;
import net.java.html.json.Models;

public final class Main {

    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
                loadPage("pages/index.html").
                loadClass(Main.class).
                invoke("onPageLoad", args).
                showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() {
        String test = StorageManager.getStorage().get("tasks");
        TaskListViewModel taskList;
        if (test == null || test.length() == 0 ) {
            taskList = new TaskListViewModel();
            taskList.getTasks().add(new Task("Buy milk", Boolean.TRUE));
        } else {
            InputStream inputStream = new ByteArrayInputStream(test.getBytes(StandardCharsets.UTF_8));
            try {
                taskList = Models.parse(BrwsrCtx.findDefault(TaskListViewModel.class), TaskListViewModel.class, inputStream);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                taskList = new TaskListViewModel();
            }
            
        }
        taskList.applyBindings();

    }

}
