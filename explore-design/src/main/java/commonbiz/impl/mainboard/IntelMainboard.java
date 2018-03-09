package commonbiz.impl.mainboard;

import commonbiz.Mainboard;

/**
 * @author wyj40124
 * @version Id: IntelMainboard, v 0.1 2018/3/9 13:54 wyj40124 Exp $
 */
public class IntelMainboard implements Mainboard {

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}