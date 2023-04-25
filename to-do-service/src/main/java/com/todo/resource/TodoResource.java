package com.todo.resource;

import com.todo.entities.Todo;
import com.todo.resource.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos", produces = {"application/json", "application/xml"})
@RequiredArgsConstructor
public class TodoResource {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> toDo() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @Operation(
            summary = "Retrieve todos",
            description = "Retrieve all TODOS from db",
            tags = {"todos", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Todo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<Todo> toDo(@PathVariable final Integer id) {
        return ResponseEntity.ok(todoService.getTodo(id));
    }

    @PostMapping
    public ResponseEntity<Todo> toDo(@RequestBody final @Valid Todo todo) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoService.createTodo(todo).getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(location).build();
    }
}
