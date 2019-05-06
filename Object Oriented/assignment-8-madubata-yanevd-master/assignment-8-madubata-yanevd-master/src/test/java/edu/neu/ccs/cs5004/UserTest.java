package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
  Integer nodeId;
  LocalDate profileCreationLocalDate;
  Character gender;
  Character gender2;
  Integer age;
  Integer age2;
  Integer age3;
  String city;
  User user;

  @Before
  public void setUp() throws Exception {
    this.nodeId = new Integer(3);
    this.profileCreationLocalDate = LocalDate.of(1982, 10, 11);
    this.gender = 'F';
    this.gender2 = 'A';
    this.age = 32;
    this.age2 = -1;
    this.age3 = 101;
    this.city = "Hyattsville";
    this.user = new User(nodeId, profileCreationLocalDate, gender, age, city);
  }

  @Test(expected = OutOfRangeException.class)
  public void OutOfRangeException() throws Exception{
    User test = new User(nodeId, profileCreationLocalDate, gender2, age, city);
    User test2 = new User(nodeId, profileCreationLocalDate, gender, age2, city);
    User test3 = new User(nodeId, profileCreationLocalDate, gender, age3, city);
  }

  @Test
  public void getNodeId() {
    Assert.assertEquals(nodeId, user.getNodeId());
  }

  @Test
  public void setNodeId() {
    this.user.setNodeId(4);
    Assert.assertEquals(user.getNodeId(), new Integer(4));
  }

  @Test
  public void setProfileCreationLocalDate() throws Exception {
    LocalDate test = LocalDate.of(1987, 12, 20);
    this.user.setProfileCreationLocalDate(test);
    Assert.assertEquals(this.user, new User(nodeId, test, gender, age, city));
  }

  @Test
  public void setGender() throws Exception {
    this.user.setGender('M');
    Assert.assertEquals(this.user, new User(nodeId, profileCreationLocalDate, 'M', age, city));
  }

  @Test
  public void setAge() throws Exception {
    this.user.setAge(23);
    Assert.assertEquals(this.user, new User(nodeId, profileCreationLocalDate, gender, 23, city));
  }

  @Test
  public void setCity() throws Exception {
    this.user.setCity("Riverdale");
    Assert.assertEquals(this.user, new User(nodeId, profileCreationLocalDate, gender, age, "Riverdale"));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(user.equals(new User(nodeId, profileCreationLocalDate, gender, age, city)));
    Assert.assertFalse(user.equals(new User(2, profileCreationLocalDate, gender, age, city)));
    LocalDate test = LocalDate.of(1987, 12, 20);
    Assert.assertFalse(user.equals(new User(nodeId, test, gender, age, city)));
    Assert.assertFalse(user.equals(new User(nodeId, profileCreationLocalDate, 'M', age, city)));
    Assert.assertFalse(user.equals(new User(nodeId, profileCreationLocalDate, gender, 23, city)));
    Assert.assertFalse(user.equals(new User(nodeId, profileCreationLocalDate, gender, age,
        "Riverdale")));
    Assert.assertFalse(user.equals(nodeId));

  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(user, new User(nodeId, profileCreationLocalDate, gender, age, city));
    Assert.assertNotEquals(user, new User(2, profileCreationLocalDate, gender, age, city));

  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("User{nodeId=3, profileCreationLocalDate=" + profileCreationLocalDate +
        ", gender=F, age=32, city='Hyattsville'}", user.toString());
  }
}