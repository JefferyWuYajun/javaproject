package commonbiz.impl.cpu;

import commonbiz.Cpu;

/**
 * @author wyj40124
 * @version Id: AmdCpu, v 0.1 2018/3/9 13:51 wyj40124 Exp $
 */
public class AmdCpu implements Cpu {

    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AMD CPU的针脚数:" + pins);
    }
}