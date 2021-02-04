package serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import model.ToDoModel;
import repository.TooRepoInterface;
import service.ToDoServiceInterface;

public class ToDoServiceImplement implements ToDoServiceInterface {

	
	TooRepoInterface todoRepo;
	@Override
	public List<ToDoModel> getTodosByUser(String user) {
		return todoRepo.searchByUserName(user);
		
	}

	@Override
	public Optional<ToDoModel> getTodoById(int id) {
		return todoRepo.findById(id);
	}

	@Override
	public void updateTodo(ToDoModel todo) {
		// TODO Auto-generated method stub
		todoRepo.save(todo);
		
	}

	@Override
	public void addTodo(String name, String desc, Date endDate, boolean isDone, Date createDate, Date modifyDate) {
		todoRepo.save(new ToDoModel(name, desc, endDate, isDone, createDate, modifyDate));
	}

	@Override
	public void deleteTodo(int id) {
		todoRepo.deleteById(id);
		Optional<ToDoModel> todo = todoRepo.findById(id);
		if(todo.isPresent()) {
			todoRepo.delete(todo.get());
		}
		
	}

	@Override
	public void saveTodo(ToDoModel todo) {
		todoRepo.save(todo);
	}

	
	
}
