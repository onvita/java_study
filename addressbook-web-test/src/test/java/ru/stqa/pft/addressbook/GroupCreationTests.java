package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test11", "test12", "test13"));
    app.submitGroupCreation();
    app.gotoGroupPage();
  }


}
