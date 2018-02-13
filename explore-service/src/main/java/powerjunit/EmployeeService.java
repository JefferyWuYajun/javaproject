package powerjunit;

/**
 * @author wyj40124
 * @version Id: EmployeeService, v 0.1 2018/2/12 14:58 wyj40124 Exp $
 */
public class EmployeeService {

    public int getEmployeeCountNew() {
        return Employee.count();
    }
}