package powerjunit;

/**
 * @author wyj40124
 * @version Id: Employee, v 0.1 2018/2/12 14:59 wyj40124 Exp $
 */
public class Employee {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int count() {
        throw new UnsupportedOperationException();
    }
}