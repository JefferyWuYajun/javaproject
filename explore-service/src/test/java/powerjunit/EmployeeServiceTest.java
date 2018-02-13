package powerjunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author wyj40124
 * @version Id: EmployeeServiceTest, v 0.1 2018/2/12 15:21 wyj40124 Exp $
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Employee.class)
public class EmployeeServiceTest {

    //    @InjectMocks
    //    private EmployeeService employeeService;

    @Test
    public void shouldReturnTheCountOfEmployeesUsingTheDomainClass() {
        PowerMockito.mockStatic(Employee.class);
        PowerMockito.when(Employee.count()).thenReturn(800);

        //        System.out.println(employeeService.getEmployeeCountNew());
        //        Assert.assertEquals(900, employeeService.getEmployeeCountNew());
    }
}