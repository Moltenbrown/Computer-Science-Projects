package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Represents a template editor with its details--list of clients to input into the templates.
 *
 * @author Goch.
 */
public class TemplateEditor {
  private ClientList clientList;

  /**
   * Creates a template editor from a filePath to the csv containing the names of the clients.
   * @param filePath the file path to the csv file containing the names of the clients.
   * @throws Exception if an I/O error occurs with readline, or the file referenced by the file
   * path does not exist.
   */
  public TemplateEditor(String filePath) throws Exception {
    this.clientList = new ClientList(filePath);
  }

  /**
   * Creates the emails or letters for each client from a path to the template for the email or letter and
   * a string pointing to the folder where the user wants the letters to be created to.
   * @param templatePath the absolute path of the file containing the email or letter template.
   * @param outputPath the absolute path of the folder where the user wants the edited letter to be sent to.
   * @throws Exception if an I/O error occurs with readline, or the file referenced by the template path
   * does not exist.
   */
  public void createFilesFromTemplate(String templatePath, String outputPath) throws Exception {
    Pattern email = Pattern.compile("\\[\\[(email)\\]\\]");
    Pattern firstName = Pattern.compile("\\[\\[(first_name)\\]\\]");
    Pattern lastName = Pattern.compile("\\[\\[(last_name)\\]\\]");
    Pattern companyName = Pattern.compile("\\[\\[(company_name)\\]\\]");
    Pattern address = Pattern.compile("\\[\\[(address)\\]\\]");
    Pattern city = Pattern.compile("\\[\\[(city)\\]\\]");
    Pattern county = Pattern.compile("\\[\\[(county)\\]\\]");
    Pattern state = Pattern.compile("\\[\\[(state)\\]\\]");
    Pattern zip = Pattern.compile("\\[\\[(zip)\\]\\]");
    Pattern phone1 = Pattern.compile("\\[\\[(phone1)\\]\\]");
    Pattern phone2 = Pattern.compile("\\[\\[(phone2)\\]\\]");
    Pattern web = Pattern.compile("\\[\\[(web)\\]\\]");

    for (Client client : this.clientList.getClientList()) {
      File outputFile = new File(outputPath + "/" + client.getFirstName() + " " +
          client.getLastName() + ".txt");
      PrintWriter outputWrite = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
      try (BufferedReader fileInput = new BufferedReader(new FileReader(templatePath))) {
        String line = null;
        while ((line = fileInput.readLine()) != null) {
          String currentLine = line;
          Matcher emailMatcher = email.matcher(currentLine);
          currentLine = emailMatcher.replaceAll(client.getEmail());
          Matcher firstNameMatcher = firstName.matcher(currentLine);
          currentLine = firstNameMatcher.replaceAll(client.getFirstName());
          Matcher lastNameMatcher = lastName.matcher(currentLine);
          currentLine = lastNameMatcher.replaceAll(client.getLastName());
          Matcher companyNameMatcher = companyName.matcher(currentLine);
          currentLine = companyNameMatcher.replaceAll(client.getCompanyName());
          Matcher addressMatcher = address.matcher(currentLine);
          currentLine = addressMatcher.replaceAll(client.getAddress());
          Matcher cityMatcher = city.matcher(currentLine);
          currentLine = cityMatcher.replaceAll(client.getCity());
          Matcher countyMatcher = county.matcher(currentLine);
          currentLine = countyMatcher.replaceAll(client.getCounty());
          Matcher stateMatcher = state.matcher(currentLine);
          currentLine = stateMatcher.replaceAll(client.getCity());
          Matcher zipMatcher = zip.matcher(currentLine);
          currentLine = zipMatcher.replaceAll(client.getZip().toString());
          Matcher phone1Matcher = phone1.matcher(currentLine);
          currentLine = phone1Matcher.replaceAll(client.getPhoneNumber());
          Matcher phone2Matcher = phone2.matcher(currentLine);
          currentLine = phone2Matcher.replaceAll(client.getPhoneNumber2());
          Matcher webMatcher = web.matcher(currentLine);
          currentLine = webMatcher.replaceAll(client.getUrl());
          outputWrite.println(currentLine);
        }
      } catch (IOException | NullPointerException ioe) {
        System.out
            .println("There was an issue with the client information input" + " " +
                ioe.getMessage());
        ioe.printStackTrace();
      }

      outputWrite.close();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TemplateEditor)) {
      return false;
    }
    TemplateEditor that = (TemplateEditor) o;
    return Objects.equals(clientList, that.clientList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientList);
  }

  @Override
  public String toString() {
    return "TemplateEditor{" +
        "clientList=" + clientList +
        '}';
  }
}
