package mochitodemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ct.data.TodoBusinessImpl;
import com.ct.service.TodoService;

public class TodoBusinessImplStubTest {
	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}

}
