package design.cabstractfactorymode.simplefactory;

import design.cabstractfactorymode.simplefactory.ComputerEngineer;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wyj40124
 * @version Id: ComputerSimpleFactoryTest, v 0.1 2018/3/9 14:07 wyj40124 Exp $
 */
public class ComputerSimpleFactoryTest {

    private ComputerEngineer computerEngineer;

    @Before
    public void before(){
        computerEngineer = new ComputerEngineer();
    }

    @Test
    public void successComputerSimpleFactoryTest() throws Exception {
        computerEngineer.makeComputer(1, 1);
    }

    @Test
    public void failComputerSimpleFactoryTest() throws Exception {
        computerEngineer.makeComputer(1, 2);
    }
}