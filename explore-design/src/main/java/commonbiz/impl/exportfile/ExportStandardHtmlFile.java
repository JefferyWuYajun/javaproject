package commonbiz.impl.exportfile;

import commonbiz.ExportFile;

/**
 * @author wyj40124
 * @version Id: ExportStandardHtmlFile, v 0.1 2018/3/9 11:39 wyj40124 Exp $
 */
public class ExportStandardHtmlFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出标准版HTML文件");
        return false;
    }
}