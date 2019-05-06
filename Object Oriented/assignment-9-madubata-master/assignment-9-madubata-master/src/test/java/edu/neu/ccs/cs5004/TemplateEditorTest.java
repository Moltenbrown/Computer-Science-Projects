package edu.neu.ccs.cs5004;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplateEditorTest {
  TemplateEditor test1;
  TemplateEditor test2;
  TemplateEditor test3;
  String filePath;
  String templatePath;
  String outputPath;
  ClientList test4;

  @Before
  public void setUp() throws Exception {
    filePath = "/Users/Goch/Desktop/theater_company_members_small.csv";
    templatePath = "/Users/Goch/Desktop/email_template.txt";
    outputPath = "/Users/Goch/Desktop/output_folder";
    test1 = new TemplateEditor(filePath);
    test2 = new TemplateEditor(filePath);
    test3 = new TemplateEditor("/Users/Goch/Desktop/theatercompanymembers.csv");
    test4 = new ClientList(filePath);
  }

  @Test
  public void createFilesFromTemplate() throws Exception {
    test1.createFilesFromTemplate(templatePath, outputPath);
    File outputDirectory = new File(outputPath);
    File[] files = outputDirectory.listFiles();
    sort(files);
    List<String> filePaths = new ArrayList<String>();
    for(File file: files) {
      String name = file.getAbsolutePath();
      filePaths.add(name);
    }
    Assert.assertTrue(filePaths.contains("/Users/Goch/Desktop/output_folder/Paz Sahagun.txt"));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(test1.equals(test2));
    Assert.assertFalse(test1.equals(test3));
    Assert.assertFalse(test1.equals(filePath));
    Assert.assertFalse(test1.equals(null));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(test1.hashCode(), test2.hashCode());
    Assert.assertNotEquals(test1.hashCode(), test3.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals(
        "TemplateEditor{" +
        "clientList=" + test4 +
        '}', test1.toString());
  }
}