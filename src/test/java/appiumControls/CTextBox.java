package appiumControls;

import org.openqa.selenium.By;

public class CTextBox extends CBaseControl {
    public CTextBox(By locator) {
        super(locator);
    }

    public void setText(String vStrText) {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(vStrText);
    }
}
