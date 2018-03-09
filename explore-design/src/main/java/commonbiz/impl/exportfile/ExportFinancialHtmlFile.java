package commonbiz.impl.exportfile;

import commonbiz.ExportFile;

/**
 * @author wyj40124
 * @version Id: ExportFinancialHtmlFile, v 0.1 2018/3/9 11:37 wyj40124 Exp $
 */
public class ExportFinancialHtmlFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出财务版HTML文件");
        return true;
    }
}