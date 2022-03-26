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
public class TodoJPAResource {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoJPARepository todoJpaRepository;
	
	
	@GetMapping(path = "/jpa/user/{username}/todos")
	public List<Todo> retrieveListOfTodos(@PathVariable String username){
		return todoJpaRepository.findAllByUsername(username);
//		return todoService.findAll();
	}
	
	@GetMapping(path = "/jpa/user/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable long id){
		return todoJpaRepository.findById(id).get();
//		return todoService.findById(id);
	}
	
	@DeleteMapping("/jpa/user/{username}/todos/{id}")
	public ResponseEntity deleteTodo(@PathVariable String username, @PathVariable long id){
//		Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
//		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/user/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
//		Todo todoUpdate = todoService.updateTodo(todo);
		Todo todoUpdate = todoJpaRepository.save(todo);
		
		return new ResponseEntity<Todo>(todoUpdate, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/user/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo){
//		Todo createdTodo = todoService.updateTodo(todo);
		todo.setUsername(username);
		Todo createdTodo = todoJpaRepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}

}
