package commonbiz.impl.mainboard;

import commonbiz.Mainboard;

/**
 * @author wyj40124
 * @version Id: AmdMainboard, v 0.1 2018/3/9 13:55 wyj40124 Exp $
 */
public class AmdMainboard implements Mainboard {

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}