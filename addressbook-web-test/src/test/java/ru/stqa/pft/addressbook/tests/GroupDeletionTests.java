package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    // Перед выбором группы  проверяем, есль ли группа, если нет - то вызываем созданеи группы
    if (app.group().list().size() ==0) {
        app.group().crate(new GroupData().withName("Test1")); }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    Set<GroupData> before=app.group().all();
    int index=before.size()-1;
    app.group().delete(index);
    Set<GroupData> after=app.group().all();
    // сравниваем количество
    Assert.assertEquals(after.size(), before.size() - 1 );
    // перед сравнением списков из старого нужно удалить удаленный в тесте элемент, по индексу
    before.remove(index);
    Assert.assertEquals(before, after);
  }




}
