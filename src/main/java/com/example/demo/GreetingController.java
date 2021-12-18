package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
@RestController
public class GreetingController {
	private static final String template="Hello,%s!";
	private static final String template2="Hello,%s %s!";
	private final AtomicLong counter=new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template,name));
	}
	@RequestMapping(value= {"","/","/home"})
	public String sayHello() {
		return "Hello From Bridgelabz";
	}
	@GetMapping("/param/{name}")
	public Greeting sayHelloParam(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template,name));
	}
	@PostMapping("/post")
	public Greeting sayHello(@RequestBody User user) {
		return new Greeting(counter.incrementAndGet(),String.format(template2,user.getFirstName(),user.getLastName()));
	}
	@PutMapping("/put/{firstName}")
	public Greeting sayHello(@PathVariable String firstName,@RequestParam(value="lastName") String lastName) {
		return new Greeting(counter.incrementAndGet(),String.format(template2,firstName,lastName));
	}
}