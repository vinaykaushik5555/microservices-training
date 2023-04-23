package com.todo.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoResource.class)
public class ToDoResourceIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Method to test get all toDos ")
    public void testGetToDo() throws Exception {
        // Act and Assert
        mockMvc.perform(get("/api/v1/todos")).andExpect(status().isOk());
    }
}
