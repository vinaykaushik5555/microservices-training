package com.todo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Entity(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String task;
    @Size(min = 5, max = 250)
    private String description;
    private String username;
    @JsonProperty(value = "isDone")
    private boolean isDone;
    private LocalDate targetDate;
}
