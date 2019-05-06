package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Represents a userqueue with its details--a list of users as a deque of users.
 * @author Goch.
 */
public class UserQueue {
  private Deque<User> userList;

  /**
   * Creates a new user queue from a string.
   * @param filePath a string stating the filepath of the file.
   * @throws Exception if an I/O error occurs with readline, or the file referenced by the file
   * path does not exist, or if the user that is created either has an age that is out of bounds or
   * has a gender that is M, F, or O.
   */
  public UserQueue(String filePath) throws Exception {
    try(BufferedReader fileInput = new BufferedReader(new FileReader(filePath))) {
      String userHolder = fileInput.readLine();
      this.userList = new ArrayDeque<User>();
      while ((userHolder = fileInput.readLine()) != null) {
        StringTokenizer userComponents = new StringTokenizer(userHolder, ",");
        User blankUser = new User(null, null, 'O', 0,
            null);
        if (userComponents.hasMoreTokens()) {
          int nodeId = Integer.parseInt(userComponents.nextToken());
          blankUser.setNodeId(nodeId);

          String date = userComponents.nextToken();
          StringTokenizer dateComponents = new StringTokenizer(date, "/");
          if (dateComponents.hasMoreTokens()) {
            int month = Integer.parseInt(dateComponents.nextToken());
            int day = Integer.parseInt(dateComponents.nextToken());
            int year = Integer.parseInt(dateComponents.nextToken());
            if (String.valueOf(year).length() < 4) {
              year = year + 2000;
            }
            LocalDate dateHolder = LocalDate.of(year, month, day);
            blankUser.setProfileCreationLocalDate(dateHolder);
          }

          char gender = userComponents.nextToken().charAt(0);
          blankUser.setGender(gender);

          int age = Integer.parseInt(userComponents.nextToken());
          blankUser.setAge(age);

          blankUser.setCity(userComponents.nextToken());
        }
        userList.addLast(blankUser);
      }
    } catch(IOException ioe) {
      System.out.println("There was an issue with the nodes input" + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Returns a user list from the user queue.
   * @returns a user list from the user queue.
   */
  public Deque<User> getUserList() {
    return userList;
  }

  /**
   * Creates and returns a new iterator specifically designed to randomly go through elements
   * in the queue.
   * @return a new iterator specifically designed to randomly go through elements in the queue.
   */

  public Iterator<User> myIterator() {
    Iterator<User> currentUser = new Iterator<User>() {
      User[] userArray = getUserList().toArray(new User[0]);
      int elementsPassed = 0;

      @Override
      public boolean hasNext() {
        if(elementsPassed < userList.size()) {
          return true;
        }

        return false;
      }

      @Override
      public User next() {
        Random randomNumber = new Random();
        Integer index = randomNumber.nextInt(userList.size());
        User holder = userArray[index];
        this.elementsPassed += 1;
        return holder;
      }
    };

    return currentUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserQueue)) {
      return false;
    }
    UserQueue userQueue = (UserQueue) o;
    Iterator<User> userIterator = userList.iterator();
    Iterator<User> userIteratorO = userQueue.userList.iterator();
    while (userIterator.hasNext()) {
      if(!Objects.equals(userIterator.next(), userIteratorO.next())){
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int total = 0;
    Iterator<User> userIterator = this.userList.iterator();
    while(userIterator.hasNext()){
      total = Objects.hash(userIterator.next());
    }
    return total;
  }

  @Override
  public String toString() {
    return "UserQueue{" +
        "userList=\n" + userList +
        '}';
  }
}
