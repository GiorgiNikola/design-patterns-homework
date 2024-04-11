package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

public class SwoopTestsFactory {
    @Parameters({"firstName", "lastName", "gender", "mobileNumber"})
    @Factory(dataProvider = "factoryDataProvider", dataProviderClass = CustomDataProvider.class)
    public Object[] factoryExecutor(String sectionName){
        return new Object[] {
                new ParametrizedSwoopTests2(sectionName)
        };
    }
}