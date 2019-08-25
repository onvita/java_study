package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

    // Перед выбором группы  проверяем, есль ли группа, если нет - то вызываем созданеи группы
    if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().crateGroup(new GroupData("test31", null, null)); }

    List<GroupData> before=app.getGroupHelper().getGroupList();

    // и только после этого уже выбираем группу для удаления
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    // сравниваем количество
    Assert.assertEquals(after.size(), before.size() - 1 );
    // перед сравнением списков из старого нужно удалить удаленный в тесте элемент, по индексу
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }


}
