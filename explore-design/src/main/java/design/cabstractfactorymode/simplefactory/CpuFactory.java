package design.cabstractfactorymode.simplefactory;

import commonbiz.Cpu;
import commonbiz.impl.cpu.AmdCpu;
import commonbiz.impl.cpu.IntelCpu;

/**
 * @author wyj40124
 * @version Id: CpuFactory, v 0.1 2018/3/9 13:58 wyj40124 Exp $
 */
public class CpuFactory {
    public static Cpu createCpu(int type) {
        Cpu cpu = null;
        if (type == 1) {
            cpu = new IntelCpu(755);
        } else if (type == 2) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}