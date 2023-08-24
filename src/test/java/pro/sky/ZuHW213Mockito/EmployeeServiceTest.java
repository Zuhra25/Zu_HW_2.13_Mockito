package pro.sky.ZuHW213Mockito;

import org.junit.jupiter.api.Test;
import pro.sky.ZuHW213Mockito.Employee;
import pro.sky.ZuHW213Mockito.exceptions.BadParamsException;
import pro.sky.ZuHW213Mockito.exceptions.EmployeeAlreadyAddedException;
import pro.sky.ZuHW213Mockito.exceptions.EmployeeNotFoundException;
import pro.sky.ZuHW213Mockito.services.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    void addEmployee() { //add работает
        Employee result = employeeService.addEmployee("Иван5", "Иванов5", 1000, 1);
        employeeService.printAll().contains(result);
    }

    @Test
    void releaseEmployeeAlreadyAddedException() { // работает исключение_1 в addEmployee
        addEmployee();
        assertEquals("этот сотрудник уже существует",
                assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee
                        ("Иван5", "Иванов5", 1000, 1)).getMessage());
    }

    @Test
    void releaseBadParamsException() { // работает исключение_2 в addEmployee
        assertEquals("поля пустые",
                assertThrows(BadParamsException.class, () -> employeeService.addEmployee
                        ("", "Иванов5", 1000, 1)).getMessage());
    }

    @Test
    void removeEmployee() { //remove работает
        addEmployee();
        Employee result = employeeService.removeEmployee("Иван5", "Иванов5", 1000, 1);
        for (Employee i : employeeService.printAll()) {
            if (i != result) ;
        }
    }

    @Test
    void removeAnExistingEmployee() { // работает исключение
        assertEquals("этот сотрудник отсутствует",
                assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee
                        ("Петр", "Иванов5", 1000, 1)).getMessage());
    }

    @Test
    void findEmployee() {  // поиск работает
        addEmployee();
        employeeService.printAll().contains(employeeService.findEmployee("Иван5", "Иванов5", 1000, 1));
    }

}

