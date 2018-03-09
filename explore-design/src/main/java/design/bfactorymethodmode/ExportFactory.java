package design.bfactorymethodmode;

import commonbiz.ExportFile;

/**
 * @author wyj40124
 * @version Id: ExportFactory, v 0.1 2018/3/9 13:31 wyj40124 Exp $
 */
public interface ExportFactory {
    ExportFile factory(String type);
}