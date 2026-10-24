package generic_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

    /**
     * Reads cell data safely from Excel using DataFormatter to handle both text and numeric cells.
     */
    public static String getDataFromExcelFile(String sheetName, int rowIndex, int cellIndex)
            throws EncryptedDocumentException, IOException {

        try (FileInputStream fis = new FileInputStream("./src/test/resources/PD.xlsx");
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sh = wb.getSheet(sheetName);
            if (sh == null) return "";

            Row row = sh.getRow(rowIndex);
            if (row == null) return "";

            Cell cell = row.getCell(cellIndex);
            if (cell == null) return "";

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }

    /**
     * Reads a property value from cd.properties.
     */
    public static String getDataFromProperties(String key) throws IOException {
        try (FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties")) {
            Properties pobj = new Properties();
            pobj.load(fis);
            return pobj.getProperty(key);
        }
    }

    /**
     * Reads a string value from cd.json by key.
     */
    public static String getDataFromJSON(String key) throws IOException, ParseException {
        try (FileReader fr = new FileReader("./src/test/resources/cd.json")) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONObject jobj = (JSONObject) obj;
            Object val = jobj.get(key);
            return val != null ? val.toString() : "";
        }
    }
}