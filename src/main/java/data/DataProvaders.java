package data;

import org.testng.annotations.DataProvider;

public class DataProvaders {
    @DataProvider
    public Object[][] dateLang(){
            return new Object[][]{
                    {"en"},
                    {"es"},
                    {"fr"}
            };
    }
    @DataProvider
    public Object[][] getdata(){
        return new Object[][]{
                {"Vasiliy","Shevchenko",456,456},
                {"Nikolay","Shevchenko",456,456},
                {"Alex","Shevchenko",456,456}
        };
    }
}
