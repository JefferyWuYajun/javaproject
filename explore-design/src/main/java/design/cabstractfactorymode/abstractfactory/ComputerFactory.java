package design.cabstractfactorymode.abstractfactory;

import commonbiz.Cpu;
import commonbiz.Mainboard;

/**
 * @author wyj40124
 * @version Id: ComputerFactory, v 0.1 2018/3/9 14:18 wyj40124 Exp $
 */
public interface ComputerFactory {
    Cpu createCpu();

    Mainboard createMainboard();
}