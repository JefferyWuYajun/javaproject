package design.cabstractfactorymode.abstractfactory;

import commonbiz.Cpu;
import commonbiz.Mainboard;
import commonbiz.impl.cpu.AmdCpu;
import commonbiz.impl.mainboard.AmdMainboard;

/**
 * @author wyj40124
 * @version Id: AmdComputerFactory, v 0.1 2018/3/9 14:20 wyj40124 Exp $
 */
public class AmdComputerFactory implements ComputerFactory {

    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }
}