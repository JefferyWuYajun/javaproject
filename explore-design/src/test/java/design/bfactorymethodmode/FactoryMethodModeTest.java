package design.bfactorymethodmode;

import commonbiz.ExportFile;
import org.junit.Test;

/**
 * @author wyj40124
 * @version Id: FactoryMethodModeTest, v 0.1 2018/3/9 13:36 wyj40124 Exp $
 */
public class FactoryMethodModeTest {
    @Test
    public void successFactoryMethodModeTest() throws Exception {
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile exportFile = exportFactory.factory("standard");
        exportFile.export("");
    }
}