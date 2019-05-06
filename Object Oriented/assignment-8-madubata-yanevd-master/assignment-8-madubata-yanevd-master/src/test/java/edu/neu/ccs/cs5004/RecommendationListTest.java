package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecommendationListTest {
  UserMap map;
  String filePath;
  RecommendationList test;
  List<Integer> listForTesting;

  @Before
  public void setUp() throws Exception {
    this.filePath = "/Users/Goch/Desktop/edges_small.csv";
    this.map = new UserMap(filePath);
    this.test = new RecommendationList(map.getUserFollowMap().get(1));
    this.listForTesting = new ArrayList<Integer>();
    this.listForTesting.add(7);
  }

  @Test(expected = InputMismatchException.class)
  public void InputMismatchException() {
    test.setAmountOfRecommendations(4);
  }

  @Test
  public void getAmountOfRecommendations() {
    Assert.assertEquals(5, test.getAmountOfRecommendations());
    Assert.assertEquals(5, test.getAmountOfRecommendations());
    Assert.assertNotEquals(6, test.getAmountOfRecommendations());
    test.addListToRecommendationList(listForTesting);
    Assert.assertEquals(6, test.getAmountOfRecommendations());
  }

  @Test
  public void setAmountOfRecommendations() {
    RecommendationList testor = new RecommendationList(listForTesting);
    testor.setAmountOfRecommendations(1);
    Assert.assertEquals(1, testor.getAmountOfRecommendations());
  }


  @Test
  public void addUserToRecommendationList () {
    test.addUserToRecommendationList(103);
    Assert.assertTrue(test.getUserList().contains(103));
  }

  @Test
  public void addListToRecommendationList() {
    listForTesting.add(6);
    listForTesting.add(7);
    System.out.println(test);
    test.addListToRecommendationList(listForTesting);
    Assert.assertEquals(8, test.getAmountOfRecommendations());
  }

  @Test
  public void equals() {
    List<Integer> listForTesting2 = new ArrayList<Integer>();
    listForTesting2.add(39);
    listForTesting2.add(79);
    listForTesting2.add(80);
    listForTesting2.add(23);
    listForTesting2.add(81);
    RecommendationList testor = new RecommendationList(listForTesting2);
    Assert.assertTrue(test.equals(testor));
    RecommendationList testor2 = new RecommendationList(listForTesting);
    Assert.assertFalse(test.equals(testor2));
    Assert.assertFalse(test.equals(listForTesting2));
  }

  @Test
  public void hashCodeTest() {
    List<Integer> listForTesting2 = new ArrayList<Integer>();
    listForTesting2.add(39);
    listForTesting2.add(79);
    listForTesting2.add(80);
    listForTesting2.add(23);
    listForTesting2.add(81);
    RecommendationList testor = new RecommendationList(listForTesting2);
    Assert.assertEquals(test.hashCode(), testor.hashCode());
    RecommendationList testor2 = new RecommendationList(listForTesting);
    Assert.assertNotEquals(test.hashCode(), testor2.hashCode());
  }

  @Test
  public void toStringTest() {
    List<Integer> listForTesting2 = new ArrayList<Integer>();
    listForTesting2.add(39);
    listForTesting2.add(79);
    listForTesting2.add(80);
    listForTesting2.add(23);
    listForTesting2.add(81);
    RecommendationList testor = new RecommendationList(listForTesting2);
    Assert.assertEquals(test.toString(), testor.toString());
  }
}