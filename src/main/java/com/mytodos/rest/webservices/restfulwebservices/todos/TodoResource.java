package com.mytodos.rest.webservices.restfulwebservices.todos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TodoResource {
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping(path = "/user/{username}/todos")
	public List<Todo> retrieveListOfTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	@GetMapping(path = "/user/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}
	
	@DeleteMapping("/user/{username}/todos/{id}")
	public ResponseEntity deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = todoService.deleteById(id);
		
		if(todo != null ) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/user/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
		Todo todoUpdate = todoService.updateTodo(todo);
		
		return new ResponseEntity<Todo>(todoUpdate, HttpStatus.OK);
	}
	
	@PostMapping("/user/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo){
		Todo createdTodo = todoService.updateTodo(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}

}
