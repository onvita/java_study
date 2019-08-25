package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification ()
  {
    app.getNavigationHelper().gotoGroupPage();

    // Перед выбором группы  проверяем, есль ли группа, если нет - то вызываем созданеи группы
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().crateGroup(new GroupData("test31", null, null)); }

    List<GroupData> before=app.getGroupHelper().getGroupList();

    // и только после этого уже выбираем группу для модификации
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group =new GroupData(before.get(before.size()-1).getId(),"test2222", "test12is", "test13is");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    // меняем старый список - удаляем старое значение, добавляем новое
    before.remove(before.size()-1);
    before.add(group);
    // создаем множества из списков и сравниваем их
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
