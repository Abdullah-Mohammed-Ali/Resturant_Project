package sample.print_screen;

import javax.print.PrintService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class printerObject implements Printable  {

    final String _text ;

    public printerObject(String text) {
        this._text = text;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /* Now we perform our rendering */
        graphics.drawString(_text, 100, 100);


        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }



    public void actionPerformed(String myPrinter) throws PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(setPrinter(myPrinter));
        job.setPrintable(this);
      /*  boolean ok = job.printDialog();
        if (ok) {
            try {*/
                job.print();
           /* } catch (PrinterException ex) {
                /* The job did not successfully complete */
           // }}
    }
    public PrintService setPrinter (String printer){
        PrintService[] printServices = PrinterJob.lookupPrintServices();

        for (PrintService printService :
                printServices) {
            if (printService.getName().equals(printer)){
               return printService;
            }

        }
        return  null;
    }
}
