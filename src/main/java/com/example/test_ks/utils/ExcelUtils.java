package com.example.test_ks.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExcelUtils {
    public static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(cell.getStringCellValue());
                    Date date1 = sdf1.parse(cell.getStringCellValue());
                    long unixTime = date.getTime();
                    long unixTime1 = date1.getTime();
                    return Math.max(unixTime1, unixTime);
                } catch (ParseException e) {
                    return cell.getStringCellValue();
                }
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().getTime();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:

            default:
                return null;
        }
    }
}
