package commonbiz.impl.cpu;

import commonbiz.Cpu;

/**
 * @author wyj40124
 * @version Id: IntelCpu, v 0.1 2018/3/9 13:49 wyj40124 Exp $
 */
public class IntelCpu implements Cpu {

    /**
     * CPU的针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU的针脚数:" + pins);
    }
}