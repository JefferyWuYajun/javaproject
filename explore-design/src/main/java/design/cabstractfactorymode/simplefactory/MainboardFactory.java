package design.cabstractfactorymode.simplefactory;

import commonbiz.Mainboard;
import commonbiz.impl.mainboard.AmdMainboard;
import commonbiz.impl.mainboard.IntelMainboard;

/**
 * @author wyj40124
 * @version Id: MainboardFactory, v 0.1 2018/3/9 14:01 wyj40124 Exp $
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type) {
        Mainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}