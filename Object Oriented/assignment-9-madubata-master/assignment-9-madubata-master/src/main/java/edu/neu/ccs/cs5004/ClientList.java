package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.Client.ClientBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a client list with its details--a list of clients as a
 * array list.
 *
 * @author Goch.
 */
public class ClientList {
  private List<Client> clientList;

  /**
   * Creates a new client list from a string.
   * @param filePath a string stating the filepath of the file. MUST BE AN ABSOLUTE FILEPATH
   * @throws Exception if an I/O error occurs with readline, or the file referenced by the file
   * path does not exist.
   */
  public ClientList(String filePath) throws Exception {
    String token = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    try(BufferedReader fileInput = new BufferedReader(new FileReader(filePath))) {
      String userHolder = fileInput.readLine();
      String[] contents = userHolder.split(",");
      int amountContained = contents.length;
      ClientBuilder holder = Client.getBuilder();
      this.clientList = new ArrayList<Client>();

      while ((userHolder = fileInput.readLine()) != null) {
        String[] potentialClients = userHolder.split(token, -1);
        for(int i = 0; i < amountContained; i++) {
          if (contents[i].equals("first_name")) {
            holder.firstName(potentialClients[i]);
          }

          if (contents[i].equals("last_name")) {
            holder.lastName(potentialClients[i]);
          }

          if (contents[i].equals("company_name")) {
            holder.companyName(potentialClients[i]);
          }

          if (contents[i].equals("address")) {
            holder.address(potentialClients[i]);
          }

          if (contents[i].equals("city")) {
            holder.city(potentialClients[i]);
          }

          if (contents[i].equals("county")) {
            holder.county(potentialClients[i]);
          }

          if (contents[i].equals("state")) {
            holder.state(potentialClients[i]);
          }

          if (contents[i].equals("zip")) {
            holder.zip(Integer.parseInt(potentialClients[i]));
          }

          if (contents[i].equals("phone1")) {
            holder.phoneNumber(potentialClients[i]);
          }

          if (contents[i].equals("phone2")) {
            holder.phoneNumber2(potentialClients[i]);
          }

          if (contents[i].equals("email")) {
            holder.email(potentialClients[i]);
          }

          if (contents[i].equals("web")) {
            holder.url(potentialClients[i]);
          }
        }

//        System.out.println("client list: before new client build");
        Client newClient = holder.build();
        this.clientList.add(newClient);
      }
    } catch(IOException | NullPointerException ioe) {
      System.out.println("There was an issue with the client information input" + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Returns the a list of clients from a client list.
   * @return the list of clients.
   */
  public List<Client> getClientList () {
    return this.clientList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ClientList)) {
      return false;
    }
    ClientList that = (ClientList) o;
    return Objects.equals(clientList, that.clientList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientList);
  }

  @Override
  public String toString() {
    return "ClientList{" +
        "clientList=" + clientList +
        '}';
  }
}
