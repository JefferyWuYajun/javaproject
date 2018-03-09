package design.cabstractfactorymode.abstractfactory;

import commonbiz.Cpu;
import commonbiz.Mainboard;

/**
 * @author wyj40124
 * @version Id: NewComputerEngineer, v 0.1 2018/3/9 14:22 wyj40124 Exp $
 */
public class NewComputerEngineer {
    /**
     * 定义组装需要的CPU
     */
    private Cpu       cpu;

    /**
     * 定义组装需要的主板
     */
    private Mainboard mainboard;

    public void makeComputer(ComputerFactory computerFactory) {

        this.cpu = computerFactory.createCpu();
        this.mainboard = computerFactory.createMainboard();

        cpu.calculate();
        mainboard.installCPU();
    }
}