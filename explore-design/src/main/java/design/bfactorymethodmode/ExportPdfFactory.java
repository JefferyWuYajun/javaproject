package design.bfactorymethodmode;

import org.apache.commons.lang3.StringUtils;

import commonbiz.ExportFile;
import commonbiz.impl.exportfile.ExportFinancialPdfFile;
import commonbiz.impl.exportfile.ExportStandardPdfFile;

/**
 * @author wyj40124
 * @version Id: ExportPdfFactory, v 0.1 2018/3/9 13:34 wyj40124 Exp $
 */
public class ExportPdfFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if (StringUtils.equals("standard", type)) {
            return new ExportStandardPdfFile();
        } else if (StringUtils.equals("financial", type)) {
            return new ExportFinancialPdfFile();
        } else {
            throw new RuntimeException("没有找到对象");
        }
    }
}