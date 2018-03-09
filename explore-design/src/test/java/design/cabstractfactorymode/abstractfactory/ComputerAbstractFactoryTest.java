package design.cabstractfactorymode.abstractfactory;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wyj40124
 * @version Id: ComputerAbstractFactoryTest, v 0.1 2018/3/9 14:16 wyj40124 Exp $
 */
public class ComputerAbstractFactoryTest {

    private NewComputerEngineer newComputerEngineer;

    @Before
    public void before() {
        newComputerEngineer = new NewComputerEngineer();
    }

    @Test
    public void successComputerAbstractFactoryTest() throws Exception {

        ComputerFactory computerFactory = new IntelComputerFactory();
        newComputerEngineer.makeComputer(computerFactory);
    }
}