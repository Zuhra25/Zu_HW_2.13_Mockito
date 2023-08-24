package pro.sky.ZuHW213Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.ZuHW213Mockito.Employee;
import pro.sky.ZuHW213Mockito.services.DepartmentServiceImpl;
import pro.sky.ZuHW213Mockito.services.EmployeeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    EmployeeService employeeService = Mockito.mock(EmployeeService.class);
    DepartmentServiceImpl departmentService = new DepartmentServiceImpl(employeeService);
    List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Роман1", "Романов1", 1000, 1),
            new Employee("Роман2", "Романов2", 2000, 1),
            new Employee("Роман3", "Романов3", 10000, 2),
            new Employee("Роман4", "Романов4", 20000, 2)));

    @BeforeEach
    public void DepartmentService() {
        when(employeeService.printAll()).thenReturn(employees);
    }

    @Test
    void maxSalaryTest() {
        Employee result = departmentService.maxSalary(1);
        Employee expected = employees.get(1);
        assertEquals(result, expected);
    }

    @Test
    void minSalaryTest() {
        Employee result = departmentService.minSalary(1);
        Employee expected = employees.get(0);
        assertEquals(result, expected);
    }

    @Test
    void sumSalaryTest() {
        String result = departmentService.sumSalary(2);
        String expected = "сумма ЗП в отделе равна 30000.0";
        assertEquals(result, expected);
    }

    @Test
    void allEmployeeInDepTest() {
        assertEquals(departmentService.allEmployeeInDep(2), employeeService.printAll().stream()
                .filter(e -> e.getDepartment() == 2)
                .collect(Collectors.toList()));
    }

    @Test
    void allEmployeepTest() {
        assertEquals(employeeService.printAll(), employees);
    }
}