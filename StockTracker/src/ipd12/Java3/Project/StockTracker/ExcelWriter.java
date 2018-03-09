
package ipd12.Java3.Project.StockTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.TableModel;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class ExcelWriter {

    private String filename;
    private WritableWorkbook workbook;

    public ExcelWriter(String fn) // get the file name from fileChooser
    {
        filename = fn;
    }

    public void write(TableModel tm) throws IOException, WriteException, FileNotFoundException {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("en", "EN"));
        workbook = Workbook.createWorkbook(new File(filename), ws);
        String tabName = "Portfolio " + Globals.currentPortfolio.getName();
        WritableSheet s = workbook.createSheet(tabName, 0);
        //Writing headers
        Label l;
        Number n;
        DateTime dt;

        //formatter for the header
        WritableFont arial10ptBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat arial10BoldFormat = new WritableCellFormat(arial10ptBold);

        //Header output
        l = new Label(0, 0, "Symbol", arial10BoldFormat);
        s.addCell(l);
        l = new Label(1, 0, "Company name", arial10BoldFormat);
        s.addCell(l);
        l = new Label(2, 0, "Created", arial10BoldFormat);
        s.addCell(l);
        l = new Label(3, 0, "Quantity", arial10BoldFormat);
        s.addCell(l);
        l = new Label(4, 0, "Entry", arial10BoldFormat);
        s.addCell(l);
        l = new Label(5, 0, "Last", arial10BoldFormat);
        s.addCell(l);
        l = new Label(6, 0, "Change", arial10BoldFormat);
        s.addCell(l);
        l = new Label(7, 0, "Value", arial10BoldFormat);
        s.addCell(l);
        l = new Label(8, 0, "Gain/Loss", arial10BoldFormat);
        s.addCell(l);
        l = new Label(9, 0, "%", arial10BoldFormat);
        s.addCell(l);

        int cols = tm.getColumnCount();
        int rows = tm.getRowCount();

        //formatters fo the columns
        WritableCellFormat cf1 = new WritableCellFormat(NumberFormats.INTEGER);
        WritableCellFormat cfi3 = new WritableCellFormat(NumberFormats.ACCOUNTING_RED_FLOAT);
        WritableCellFormat cfi4 = new WritableCellFormat(NumberFormats.PERCENT_FLOAT);
            
        NumberFormat pounddp2 = new NumberFormat("$#0.00");
        WritableCellFormat pounddp2cell = new WritableCellFormat(pounddp2);

        NumberFormat dollarCurrency
                = new NumberFormat(NumberFormat.CURRENCY_DOLLAR + " #,###.00",
                        NumberFormat.COMPLEX_FORMAT);
        WritableCellFormat dollarFormat
                = new WritableCellFormat(dollarCurrency);
        WritableCellFormat df = new WritableCellFormat(DateFormats.FORMAT2);

        // Data output
        for (int row = 0; row < rows; row++) {
            //symbol
            l = new Label(0, row + 1, tm.getValueAt(row, 0).toString());
            s.addCell(l);
            //name
            l = new Label(1, row + 1, Globals.currentTradesSet.get(row).name);
            s.addCell(l);
            //date
            Date date = Globals.currentTradesSet.get(row).opDate;
            dt = new DateTime(2, row + 1, date, df);
            s.addCell(dt);
            //quantity
            n = new Number(3, row + 1, Integer.valueOf(tm.getValueAt(row, 1).toString()), cf1);
            s.addCell(n);
            //entry
            n = new Number(4, row + 1, Double.valueOf(tm.getValueAt(row, 2).toString()), pounddp2cell);
            s.addCell(n);
            //last
            n = new Number(5, row + 1, Double.valueOf(tm.getValueAt(row, 3).toString()), pounddp2cell);
            s.addCell(n);
            //change
            n = new Number(6, row + 1, Double.valueOf(tm.getValueAt(row, 4).toString()), cfi3);
            s.addCell(n);
            //value
            n = new Number(7, row + 1, Double.valueOf(tm.getValueAt(row, 5).toString()), dollarFormat);
            s.addCell(n);
            //gain/loss
            n = new Number(8, row + 1, Double.valueOf(tm.getValueAt(row, 6).toString()), cfi3);
            s.addCell(n);
            // %
            String pValue = tm.getValueAt(row, 7).toString();
            pValue = pValue.replaceAll(" %", "");
            n = new Number(9, row + 1, (Double.valueOf(pValue) / 100), cfi4);
            s.addCell(n);
        }
        CellView cf = new CellView();
        cf.setAutosize(true);
        s.setColumnView(1, cf);
        cf = new CellView();
        cf.setSize(3500);
        s.setColumnView(7, cf);
        cf = new CellView();
        cf.setSize(3500);
        s.setColumnView(8, cf);
        cf = new CellView();
        cf.setSize(2800);
        s.setColumnView(9, cf);
        cf = new CellView();
        cf.setSize(500);
        s.setRowView(0, cf);

        workbook.write();
        workbook.close();

    }
}
