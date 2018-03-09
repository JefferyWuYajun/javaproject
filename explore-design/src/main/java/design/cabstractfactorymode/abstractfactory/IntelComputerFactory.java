package design.cabstractfactorymode.abstractfactory;

import commonbiz.Cpu;
import commonbiz.Mainboard;
import commonbiz.impl.cpu.IntelCpu;
import commonbiz.impl.mainboard.IntelMainboard;

/**
 * @author wyj40124
 * @version Id: IntelComputerFactory, v 0.1 2018/3/9 14:19 wyj40124 Exp $
 */
public class IntelComputerFactory implements ComputerFactory {
    @Override
    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(755);
    }
}