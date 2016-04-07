/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import POS.customers.Customers;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.FitIn;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;

/**
 *
 * @author Ronald
 */
public class Excel {

    public static class to_encoded {

        public final String id;
        public final String customer_name;
        public final String fname;
        public final String lname;
        public final String client_id;
        public final String client_type;
        public final String member_type;
        public final String membership;

        public to_encoded(String id, String customer_name, String fname, String lname, String client_id, String client_type, String member_type, String membership) {
            this.id = id;
            this.customer_name = customer_name;
            this.fname = fname;
            this.lname = lname;
            this.client_id = client_id;
            this.client_type = client_type;
            this.member_type = member_type;
            this.membership = membership;
        }

    }

    public static void main(String[] args) {
        List<to_encoded> datas = showExcelData("");
        for (to_encoded to : datas) {
            try {
                Date d = DateType.slash.parse(to.membership);
                String d2=DateType.sf.format(d);
//                S1_customers.to_customers to1 = new S1_customers.to_customers(FitIn.toInt(to.id), "", to.fname, to.lname
//                        , to.client_id, to.client_type, to.member_type, d2);
//                S1_customers.add_customers(to1);
            } catch (ParseException ex) {
                Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static List<to_encoded> showExcelData(String path) {
        String file = "C:\\Users\\Ronald\\Desktop\\master.xls";

        final String file2 = file;

        FileInputStream fis = null;
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unsupported Format");
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        List<to_encoded> datas = new ArrayList();
        try {
            fis = new FileInputStream(file);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[8];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 8) {
                        break;
                    }
                    if (j == 0) {
                        data = "" + cell.getNumericCellValue();

                    } else {
                        data = cell.getStringCellValue();
                    }
                    record[record_size] = data;
                    System.out.print(data + " | ");
                    record_size++;
                }

                to_encoded t = new to_encoded(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7]);
                if (record[0] != null) {
                    datas.add(t);
                    System.out.println("");
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

}
