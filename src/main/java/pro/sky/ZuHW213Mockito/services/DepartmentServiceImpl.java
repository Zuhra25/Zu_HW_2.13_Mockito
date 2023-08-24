package pro.sky.ZuHW213Mockito.services;


import org.springframework.stereotype.Service;
import pro.sky.ZuHW213Mockito.Employee;
import pro.sky.ZuHW213Mockito.exceptions.BadParamsException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int dep) {  // Найти сотрудника с максимальной зарплатой.
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new BadParamsException("не найдет сотрудник с макс ЗП"));
    }

    public Employee minSalary(int dep) {  // Найти сотрудника с максимальной зарплатой.
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .min(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow(() -> new BadParamsException("не найдет сотрудник с мин ЗП"));
    }

    public String sumSalary(int dep) {  // Найти сумму ЗП в отделе.
        double totalSalaryInDep = employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .mapToDouble(Employee::getSalary)
                .sum();
        return  "сумма ЗП в отделе равна " + totalSalaryInDep;
    }

    public List<Employee> allEmployeeInDep(int dep) {
        return employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == dep)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService.printAll().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
    }

}
