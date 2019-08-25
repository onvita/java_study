package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before=app.getGroupHelper().getGroupList();     // before и after - будут содержать список элементов- список объектов типа GroupData
    app.getGroupHelper().crateGroup(new GroupData("test31", null, null));
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1 ); // сравниваем размер списков до и после добавления

  }


}
