package pro.sky.ZuHW213Mockito.services;

import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.ZuHW213Mockito.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee maxSalary(int dep);

    public Employee minSalary(int dep);
    public String sumSalary(int dep);

    public List<Employee> allEmployeeInDep(int dep);

    public Map<Integer, List<Employee>> allEmployee();
}