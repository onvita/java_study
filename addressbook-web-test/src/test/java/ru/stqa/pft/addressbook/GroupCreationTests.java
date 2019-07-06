package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test11", "test12", "test13"));
    submitGroupCreation();
    gotoGroupPage();
  }


}
