package pl.piomin.services.elasticsearch.controller;

import java.util.List;

import pl.piomin.services.elasticsearch.entity.*;
import pl.piomin.services.elasticsearch.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@RequestMapping(method = RequestMethod.POST)
	public Employee add(@RequestBody Employee employee) {
		return repository.save(employee);
	}

	//@GetMapping("/{name}")
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public List<Employee> findByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	//@GetMapping("/organization/{organizationName}")
	@RequestMapping(method = RequestMethod.GET, value = "/organization/{organizationName}")
	public List<Employee> findByOrganizationName(@PathVariable("organizationName") String organizationName) {
		return repository.findByOrganizationName(organizationName);
	}

}
