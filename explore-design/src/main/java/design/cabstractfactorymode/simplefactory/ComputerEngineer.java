package design.cabstractfactorymode.simplefactory;

import commonbiz.Cpu;
import commonbiz.Mainboard;

/**
 * @author wyj40124
 * @version Id: ComputerEngineer, v 0.1 2018/3/9 14:03 wyj40124 Exp $
 */
public class ComputerEngineer {

    /**
     * 定义组装需要的CPU
     */
    private Cpu       cpu;

    /**
     * 定义组装需要的主板
     */
    private Mainboard mainboard;

    public void makeComputer(int cpuType, int mainboardType) {
        cpu = CpuFactory.createCpu(cpuType);
        mainboard = MainboardFactory.createMainboard(mainboardType);
        cpu.calculate();
        mainboard.installCPU();
    }
}