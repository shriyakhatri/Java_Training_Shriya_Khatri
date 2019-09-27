package mochitodemo;

import java.util.Arrays;
import java.util.List;

import com.ct.service.TodoService;

public class TodoServiceStub implements TodoService  {
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");

}

	public void deleteTodo(String capture) {
		// TODO Auto-generated method stub
		
	}
}