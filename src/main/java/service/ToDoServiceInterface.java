package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import model.ToDoModel;


public interface ToDoServiceInterface {

	List<ToDoModel> getTodosByUser(String user);

	Optional<ToDoModel> getTodoById(int id);

	void updateTodo(ToDoModel todo);

	void addTodo(String name, String desc, Date targetDate, boolean isDone,Date createDate,Date modifyDate);

	void deleteTodo(int id);
	
	void saveTodo(ToDoModel todo);
	
}
