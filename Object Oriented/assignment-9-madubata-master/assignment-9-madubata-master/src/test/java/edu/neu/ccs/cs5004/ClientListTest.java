package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.Client.ClientBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientListTest {

  ClientList test;
  ClientBuilder test3;
  Client test4;
  List<Client> test2;

  @Before
  public void setUp() throws Exception {
    test = new ClientList("/Users/Goch/Desktop/theater_company_members_small.csv");
    test3 = Client.getBuilder();
    test3.firstName("Louvenia")
        .lastName("Beech")
        .companyName("John Ortiz Nts Therapy Center")
        .address("598 43rd St")
        .county("Beverly Hills")
        .city("Los Angeles")
        .state("CA")
        .zip(90210)
        .phoneNumber("310-820-2117")
        .phoneNumber2("310-652-2379")
        .email("louvenia.beech@beech.com")
        .url("http://www.johnortizntstherapycenter.com");
    test4 = test3.build();
    test2 = test.getClientList();
  }

  @Test
  public void getClientList() {
    List<Client> holder = new ArrayList<Client>();
    Assert.assertTrue(test2.getClass().equals(holder.getClass()));
    Assert.assertTrue(test2.contains(test4));

  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(test.equals(new ClientList("/Users/Goch/Desktop/theater_company_members_small.csv")));
    Assert.assertFalse(test.equals(new ClientList("/Users/Goch/Desktop/theatercompanymembers.csv")));
    Assert.assertFalse(test.equals(test3));
    Assert.assertFalse(test.equals(null));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(test.hashCode(), new ClientList("/Users/Goch/Desktop/theater_company_members_small.csv").hashCode());
    Assert.assertNotEquals(test.hashCode(), new ClientList("/Users/Goch/Desktop/theatercompanymembers.csv").hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("ClientList{" +
        "clientList=" + test2 +
        '}', test.toString());
  }
}