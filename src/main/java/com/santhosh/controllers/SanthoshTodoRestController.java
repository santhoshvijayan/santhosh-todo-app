package com.santhosh.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.models.Tasks;
import com.santhosh.repositories.TodoRepository;

@RestController
@RequestMapping("/tasks")
public class SanthoshTodoRestController {

	@GetMapping
	public Collection<Tasks> tasks() {
		return this.todoRepository.findAll();
	}

	@GetMapping("/ping")
	public String ping() {
		System.out.println("test");
		return "Test";
	}

	@GetMapping("/{id}")
	public Tasks getTaskById(@PathVariable("id") String id) {
		return todoRepository.findOne(id);
	}

	@PostMapping
	public void saveTask(@RequestBody @Valid Tasks task) {
		task.setId(null);
		todoRepository.save(task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable("id") String id) {
		todoRepository.delete(id);
	}

	@PutMapping("/edit/{id}")
	public void editTask(@RequestBody @Valid Tasks editedTask, @PathVariable("id") String id) {
		editedTask.setId(id);
		todoRepository.save(editedTask);
	}

	@Autowired
	TodoRepository todoRepository;
}