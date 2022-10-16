package activities;

import appiumControls.CButton;
import appiumControls.CTextBox;
import org.openqa.selenium.By;

public class CCreateNoteActivity {
    public CTextBox tbxTitleNote = new CTextBox(
      By.id("com.vrproductiveapps.whendo:id/noteTextTitle")
    );
    public CTextBox tbxContentNote = new CTextBox(
      By.id("com.vrproductiveapps.whendo:id/noteTextNotes")
    );
    public CButton btnSaveNote = new CButton(
      By.id("com.vrproductiveapps.whendo:id/saveItem")
    );
    public CButton btnDeleteNote = new CButton(
      By.id("com.vrproductiveapps.whendo:id/deleteItem")
    );
    public CButton btnPopUpDelete = new CButton(
      By.id("android:id/button1")
    );
}
