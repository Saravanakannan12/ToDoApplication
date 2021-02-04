package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ToDoModel;

public interface TooRepoInterface extends JpaRepository<ToDoModel, Integer> {
	List<ToDoModel>searchByUserName(String user); 

}
