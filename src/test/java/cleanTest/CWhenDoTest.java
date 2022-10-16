package cleanTest;

import activities.CCreateNoteActivity;
import activities.CMainActivity;
import org.junit.jupiter.api.*;
import singletonSession.CSession;
import utils.CWhenDoNoteUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CWhenDoTest {
    CMainActivity mainActivity = new CMainActivity();
    CCreateNoteActivity createNoteActivity = new CCreateNoteActivity();
    private final String pStrTitle = "TEST_TITLE";
    private final String pStrContent = "TEST_CONTENT";

    @Test
    @Order(1)
    public void createNoteTest(){

        mainActivity.btnAddNote.click();
        createNoteActivity.tbxTitleNote.setText(pStrTitle);
        createNoteActivity.tbxContentNote.setText(pStrContent);
        createNoteActivity.btnSaveNote.click();

        Assertions.assertTrue(
          mainActivity.isNoteDisplayed(pStrTitle), 
          "ERROR: The NOTE was not created"
        );

    }

    @Test
    @Order(2)
    public void updateNoteTest() {

        if (!CWhenDoNoteUtil.createNote(pStrTitle, pStrContent, mainActivity, createNoteActivity))
            Assertions.fail("ERROR: The NOTE was not created");

        mainActivity.getNoteOfList(pStrTitle).click();
        String vStrTitle = pStrTitle + "_UPDATED";
        String vStrContent = pStrContent + "_UPDATED";

        createNoteActivity.tbxTitleNote.setText(vStrTitle);
        createNoteActivity.tbxContentNote.setText(vStrContent);
        createNoteActivity.btnSaveNote.click();

        Assertions.assertTrue(
          mainActivity.isNoteDisplayed(vStrTitle), 
          "ERROR: The NOTE was not updated"
        );
    }

    @Test
    @Order(3)
    public void deleteNoteTest() {
        String vStrTitle = pStrTitle + "_UPDATED";
        String vStrContent = pStrContent + "_UPDATED";

        if (!CWhenDoNoteUtil.createNote(vStrTitle, vStrContent, mainActivity, createNoteActivity))
            Assertions.fail("ERROR: The NOTE was not created");

        mainActivity.getNoteOfList(vStrTitle).click();
        createNoteActivity.btnDeleteNote.click();
        createNoteActivity.btnPopUpDelete.click();

        Assertions.assertFalse(
          mainActivity.isNoteDisplayed(vStrTitle), 
          "ERROR: The NOTE was not deleted"
        );
    }

    @AfterAll
    public static void close(){
        CSession.getInstance().closeApp();
    }
}
