package activities;

import appiumControls.CButton;
import appiumControls.CLabel;
import org.openqa.selenium.By;

public class CMainActivity {
    public CButton btnAddNote = new CButton(By.id("com.vrproductiveapps.whendo:id/fab"));

    public CLabel labNoteOfList;

    public CMainActivity() {}

    public CLabel getNoteOfList(String vStrTitle) {
        labNoteOfList = new CLabel(
          By.xpath("//android.widget.TextView[@text='" + vStrTitle + "']")
        );
        return labNoteOfList;
    }

    public boolean isNoteDisplayed(String title) {
        return getNoteOfList(title).isDisplayed();
    }
}
