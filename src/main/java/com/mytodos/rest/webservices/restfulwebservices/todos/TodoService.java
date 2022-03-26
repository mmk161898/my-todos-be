package com.mytodos.rest.webservices.restfulwebservices.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0; 
	
	static {
		todos.add(new Todo(++idCounter, "Meet", "Learn Angular to become full Stack.", new Date(), false));
		todos.add(new Todo(++idCounter, "Meet", "Learn React to become full Stack.", new Date(), false));
		todos.add(new Todo(++idCounter, "Meet", "Learn Java Springboot to become full Stack.", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo updateTodo(Todo todo) {
		if(todo.getId() == -1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo != null) {
			todos.remove(todo);
			return todo;
		}
		return null;
	}
	
	public Todo findById(long id) {
		for(Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
