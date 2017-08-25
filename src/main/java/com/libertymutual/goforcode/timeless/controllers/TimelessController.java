package com.libertymutual.goforcode.timeless.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libertymutual.goforcode.timeless.models.TimeSheet;
import com.libertymutual.goforcode.timeless.services.TimeSheetRepository;
import com.libertymutual.goforcode.todolist.models.ToDoItem;

@Controller
@RequestMapping ("/")

public class TimelessController {
	
		private TimeSheetRepository repository;
		public TimelessController(TimeSheetRepository repository) {
			this.repository = repository;
		}
	

	@GetMapping ("") 
		public String showDefault(Model model) {
			model.addAttribute("timesEntered", true);
			model.addAttribute("totalHours", 12);
			return "timeless/default";
		}
	
	@PostMapping ("update")
		public String update(TimeSheet item) {
		repository.create(item);
		return "redirect:/";
	}
	
	 @PostMapping("todos/{id}/delete")
	    public String complete(@PathVariable int id) {
	        ToDoItem item = repository.getById(id);
	        item.setComplete(true);
	        repository.update(item);
	        return "redirect:/todos";
	    }
	
	

}
