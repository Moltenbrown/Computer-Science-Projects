package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
  String firstName;
  String lastName;
  String companyName;
  String address;
  String city;
  String county;
  String state;
  Integer zip;
  String phoneNumber;
  String phoneNumber2;
  String email;
  String url;
  Client test;
  Client test2;
  Client test3;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Sarah";
    this.lastName = "Gilbert";
    this.companyName = "Samsung";
    this.address = "555 Main St";
    this.city = "Cleveland";
    this.county = "Cuyahoga";
    this.state = "Ohio";
    this.zip = 44107;
    this.phoneNumber = "999-223-0655";
    this.phoneNumber2 = "213-330-3259";
    this.email = "help@yahoo.com";
    this.url = "https://www.yahoo.com";
    test = Client.getBuilder()
        .firstName(firstName)
        .lastName(lastName)
        .companyName(companyName)
        .address(address)
        .city(city)
        .county(county)
        .state(state)
        .zip(zip)
        .phoneNumber(phoneNumber)
        .phoneNumber2(phoneNumber2)
        .email(email)
        .url(url)
        .build();
    this.test2 = Client.getBuilder()
        .firstName(firstName)
        .lastName(lastName)
        .companyName(companyName)
        .address(address)
        .city(city)
        .county(county)
        .state(state)
        .zip(zip)
        .phoneNumber(phoneNumber)
        .phoneNumber2(phoneNumber2)
        .email(email)
        .url(url)
        .build();
    this.test3 = Client.getBuilder()
        .firstName(null)
        .lastName(null)
        .companyName(null)
        .address(null)
        .city(null)
        .county(null)
        .state(null)
        .zip(null)
        .phoneNumber(null)
        .phoneNumber2(null)
        .email(null)
        .url(null)
        .build();
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals(test.getFirstName(), firstName);
  }

  @Test
  public void getLastName() {
    Assert.assertEquals(test.getLastName(), lastName);
  }

  @Test
  public void getCompanyName() {
    Assert.assertEquals(test.getCompanyName(), companyName);
  }

  @Test
  public void getAddress() {
    Assert.assertEquals(test.getAddress(), address);
  }

  @Test
  public void getCity() {
    Assert.assertEquals(test.getCity(), city);
  }

  @Test
  public void getCounty() {
    Assert.assertEquals(test.getCounty(), county);
  }

  @Test
  public void getState() {
    Assert.assertEquals(test.getState(), state);
  }

  @Test
  public void getZip() {
    Assert.assertEquals(test.getZip(), zip);
  }

  @Test
  public void getPhoneNumber() {
    Assert.assertEquals(test.getPhoneNumber(), phoneNumber);
  }

  @Test
  public void getPhoneNumber2() {
    Assert.assertEquals(test.getPhoneNumber2(), phoneNumber2);
  }

  @Test
  public void getEmail() {
    Assert.assertEquals(test.getEmail(), email);
  }

  @Test
  public void getUrl() {
    Assert.assertEquals(test.getUrl(), url);
  }

  @Test
  public void equals() {
    Assert.assertTrue(test.equals(test2));
    Assert.assertFalse(test.equals(test3));
    Assert.assertFalse(test.equals(null));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(null).lastName(lastName).companyName(companyName).address(address).city(city)
            .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(null).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(null).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(null).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(null)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(null).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(null).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(null).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(null).phoneNumber2(phoneNumber2).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(null).email(email).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(null).url(url).build()));
    Assert.assertFalse(test.equals(Client.getBuilder().firstName(firstName).lastName(lastName).companyName(companyName).address(address).city(city)
        .county(county).state(state).zip(zip).phoneNumber(phoneNumber).phoneNumber2(phoneNumber2).email(email).url(null).build()));
    Assert.assertFalse(test.equals(city));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
    Assert.assertNotEquals(test.hashCode(), test3.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals(test.toString(), "Client{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", companyName='" + companyName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", county='" + county + '\'' +
        ", state='" + state + '\'' +
        ", zip=" + zip +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", phoneNumber2='" + phoneNumber2 + '\'' +
        ", email='" + email + '\'' +
        ", url='" + url + '\'' +
        '}');
  }
}