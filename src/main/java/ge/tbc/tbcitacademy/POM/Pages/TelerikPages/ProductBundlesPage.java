package ge.tbc.tbcitacademy.POM.Pages.TelerikPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.POM.Data.Constants;

import static com.codeborne.selenide.Selenide.*;

public class ProductBundlesPage {
    public SelenideElement ultimateSupport = $x("//th[@class='Ultimate']//p[@class='u-fs12 u-fwn u-mb0']"),
    completeSupport = $x("//th[@class='Complete']//p[@class='u-fs12 u-fwn u-mb0']"),
    uiSupport = $("th[class='UI is-active'] p[class='u-fs12 u-fwn u-mb0']"),
    telerikTestStudio = $x("//p[contains(text(),'Telerik Test Studio')]/parent::td"),
    telerikReportServer = $x("//p[contains(text(),'Telerik Report Server')]/parent::td/following-sibling::td[3]"),
    buyBtn = $("th[class='Complete'] a[class='Btn Btn--prim4 u-db']");
    public ElementsCollection uiFeatures = $$x("//th[@class='UI is-active']//child::ul/li"),
    completeFeatures = $$x("//th[@class='Complete']//child::ul/li"),
    ultimateFeatures = $$x("//th[@class='Ultimate']//child::ul/li"),
    telerikTestStudioTds = telerikTestStudio.parent().$$(Constants.tdTxt),
    uiForJqueryTds = $$x("//td[text()='Kendo UI for jQuery']/following-sibling::td"),
    telerikReportingTds = $$x("//p[contains(text(),'Telerik Reporting')]/parent::td/following-sibling::td"),
    accessToVideosTds = $$x("//td[contains(text(),'Access to on-demand videos')]/following-sibling::td"),
    offerNames = $$("thead.track--pricing-head div.u-tac h5");
}
