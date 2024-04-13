package ge.tbc.tbcitacademy.Tests;

import ge.tbc.tbcitacademy.POM.DataProvider.CustomDataProvider;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import io.qameta.allure.*;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Epic("Swoop Website Navigation")
public class SwoopTestsFactory {
    @Severity(SeverityLevel.NORMAL)
    @Feature("Section Navigation")
    @Story("Verify 'გაანაწილე 4 თვეზე' button")
    @Parameters({"firstName", "lastName", "gender", "mobileNumber"})
    @Factory(dataProvider = "factoryDataProvider", dataProviderClass = CustomDataProvider.class)
    public Object[] factoryExecutor(String sectionName){
        return new Object[] {
                new ParametrizedSwoopTests2(sectionName)
        };
    }
}