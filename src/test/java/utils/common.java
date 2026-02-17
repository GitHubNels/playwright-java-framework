package utils;

public class common
{
    String filepath = "src/test/resources/testdata/LoginTestData.xlsx";
    String SheetName = "LoginData";

public String getExcelValue(int rowIndex,int colIndex)
{
    return GetExcelData.getCellData(filepath,SheetName,rowIndex,colIndex);
}
}
