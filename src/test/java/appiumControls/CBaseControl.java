package appiumControls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.CSession;

public class CBaseControl {

    protected By locator;
    protected WebElement control;

    public CBaseControl(By locator) {
        this.locator = locator;
    }

    public void findControl() {
        this.control = CSession.getInstance().getDriver().findElement(this.locator);
    }

    public void click() {
        this.findControl();
        this.control.click();
    }

    public String getText() {
        this.findControl();
        return this.control.getText();
    }

    public boolean isDisplayed() {
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
