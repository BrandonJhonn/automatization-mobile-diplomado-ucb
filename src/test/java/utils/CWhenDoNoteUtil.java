package utils;

import activities.CCreateNoteActivity;
import activities.CMainActivity;

public class CWhenDoNoteUtil {
    public static boolean createNote(
      String title, String content, 
      CMainActivity mainActivity, 
      CCreateNoteActivity createNoteActivity
    ) {
        if (!mainActivity.isNoteDisplayed(title)) {
            mainActivity.btnAddNote.click();
            createNoteActivity.tbxTitleNote.setText(title);
            createNoteActivity.tbxContentNote.setText(content);
            createNoteActivity.btnSaveNote.click();
        }
        return mainActivity.isNoteDisplayed(title);
    }
}
