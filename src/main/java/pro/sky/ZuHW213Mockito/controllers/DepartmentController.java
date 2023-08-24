package pro.sky.ZuHW213Mockito.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.ZuHW213Mockito.Employee;
import pro.sky.ZuHW213Mockito.services.DepartmentServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentServiceImpl.maxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentServiceImpl.minSalary(departmentId);
    }


    @GetMapping("/sum-salary")
    public String sumSalary(@RequestParam int departmentId) {
        return departmentServiceImpl.sumSalary(departmentId);
    }

    @GetMapping("all")
    public List<Employee> allEmployeeInDep(@RequestParam int departmentId) {
        return departmentServiceImpl.allEmployeeInDep(departmentId);
    }

    @GetMapping
    public Map<Integer, List<Employee>> allEmployee() {
        return departmentServiceImpl.allEmployee();
    }
}