package pro.sky.ZuHW213Mockito.controllers;


import org.springframework.web.bind.annotation.*;
import pro.sky.ZuHW213Mockito.Employee;
import pro.sky.ZuHW213Mockito.services.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return employeeService.removeEmployee(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam double salary, @RequestParam int department) {
        return employeeService.findEmployee(firstName, lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> printAll() {
        return employeeService.printAll();
    }
}