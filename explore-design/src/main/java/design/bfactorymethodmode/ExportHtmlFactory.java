package design.bfactorymethodmode;

import org.apache.commons.lang3.StringUtils;

import commonbiz.ExportFile;
import commonbiz.impl.exportfile.ExportFinancialHtmlFile;
import commonbiz.impl.exportfile.ExportStandardHtmlFile;

/**
 * @author wyj40124
 * @version Id: ExportHtmlFactory, v 0.1 2018/3/9 13:32 wyj40124 Exp $
 */
public class ExportHtmlFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if (StringUtils.equals("standard", type)) {
            return new ExportStandardHtmlFile();
        } else if (StringUtils.equals("financial", type)) {
            return new ExportFinancialHtmlFile();
        } else {
            throw new RuntimeException("没有找到对象");
        }
    }
}