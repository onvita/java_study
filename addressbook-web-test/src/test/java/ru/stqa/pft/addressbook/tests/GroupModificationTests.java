package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification ()
  {
    app.getNavigationHelper().gotoGroupPage();
    int before=app.getGroupHelper().getGroupCount();
    // Перед выбором группы  проверяем, есль ли группа, если нет - то вызываем созданеи группы
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().crateGroup(new GroupData("test31", null, null)); }
    // и только после этого уже выбираем группу для модификации
    app.getGroupHelper().selectGroup(before-1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test2222", "test12is", "test13is"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
