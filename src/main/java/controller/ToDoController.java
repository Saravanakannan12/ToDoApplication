package controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.ToDoModel;



@Controller
public class ToDoController {
	
	@Autowired
	private service.ToDoServiceInterface toDoService;
	
	//Displaying the ToDoItems according to the user name
	@RequestMapping(value = "/showTodoItems", method = RequestMethod.GET)
	private String showToDos(ModelMap model) {
		String userName = getUserName(model);
		model.put("todoTable", toDoService.getTodosByUser(userName));
		return "showTodoItems";
	}
	
	//Getting the user name using spring security
	private String getUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}
	
		//
	@RequestMapping(value = "/addToDoItems", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new ToDoModel());
		return "todo";
	}
	
	@RequestMapping(value = "/addToDoItems", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid ToDoModel todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getUserName(model));
		toDoService.saveTodo(todo);
		return "redirect:/showTodoItems";
	}
	
	@RequestMapping(value = "/deleteToDoItems", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		toDoService.deleteTodo(id);
		return "redirect:/showTodoItems";
	}
	
	@RequestMapping(value = "/updateToDoItems", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid ToDoModel todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getUserName(model));
		toDoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/updateToDoPageView", method = RequestMethod.GET)
	public String viewUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Optional<ToDoModel> todo = toDoService.getTodoById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	
}