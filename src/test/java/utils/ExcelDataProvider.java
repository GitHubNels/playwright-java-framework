package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "loginExcelData")
    public static Object[][] getLoginData() {

        return ExcelUtil.getTestData(
                "src/test/resources/testdata/LoginTestData.xlsx",
                "LoginData"
        );
    }
}
