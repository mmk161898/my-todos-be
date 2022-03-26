package com.mytodos.rest.webservices.restfulwebservices.todos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long>{
	List<Todo> findAllByUsername(String username);
}
