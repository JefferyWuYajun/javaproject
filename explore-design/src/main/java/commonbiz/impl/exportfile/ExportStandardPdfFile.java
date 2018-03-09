package commonbiz.impl.exportfile;

import commonbiz.ExportFile;

/**
 * @author wyj40124
 * @version Id: ExportStandardPdfFile, v 0.1 2018/3/9 11:40 wyj40124 Exp $
 */
public class ExportStandardPdfFile implements ExportFile {
    @Override
    public boolean export(String data) {
        System.out.println("导出标准版PDF文件");
        return false;
    }
}