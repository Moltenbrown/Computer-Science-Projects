package edu.neu.ccs.cs5004;

import static java.util.Arrays.sort;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorrespondenceMakerTest {
  CorrespondenceMaker test;
  CorrespondenceMaker test2;
  String filePath;
  String filePath2;
  String templatePath;
  String outputPath;
  String outputPath2;

  @Before
  public void setUp() throws Exception {
    filePath = "/Users/Goch/Desktop/theater_company_members_small.csv";
    filePath2 = "/Users/Goch/Desktop/theatercompanymembers.csv";
    templatePath = "/Users/Goch/Desktop/email_template.txt";
    outputPath = "/Users/Goch/Desktop/output_folder";
    outputPath2 = "/Users/Goch/Desktop/output_folder2";
    test = new CorrespondenceMaker();
    test2 = new CorrespondenceMaker();
  }

  @Test
  public void correspondence() throws Exception {
    test.Correspondence(templatePath, outputPath, filePath);
    test2.Correspondence(templatePath, outputPath2, filePath2);
    File outputDirectory = new File(outputPath);
    File[] files = outputDirectory.listFiles();
    sort(files);
    List<String> filePaths = new ArrayList<String>();
    for(File file: files) {
      String name = file.getAbsolutePath();
      filePaths.add(name);
    }

    List<String> filePaths2 = new ArrayList<String>();
    File outputDirectory2 = new File(outputPath2);
    File[] files2 = outputDirectory2.listFiles();
    sort(files2);
    for(File file2: files2) {
      String name = file2.getAbsolutePath();
      filePaths2.add(name);
    }

    Assert.assertTrue(filePaths.contains("/Users/Goch/Desktop/output_folder/Paz Sahagun.txt"));
    Assert.assertFalse(filePaths.contains("/Users/Goch/Desktop/output_folder/"
        + "Catalina Tillotson.txt"));
    Assert.assertFalse(filePaths.equals(filePaths2));
  }

  @Test
  public void setTemplateEditor() throws Exception {
    Assert.assertNull(test.templateEditor);
    Assert.assertNull(test2.templateEditor);
    test.setTemplateEditor(new TemplateEditor(filePath2));
    Assert.assertNotEquals(test.templateEditor, test2.templateEditor);
    Assert.assertEquals(test.templateEditor, new TemplateEditor(filePath2));
  }

  @Test
  public void setTemplatePathTest() throws Exception {
    Assert.assertNull(test.templatePath);
    test.setTemplatePath(templatePath);
    Assert.assertNotNull(test.templatePath);
    Assert.assertEquals(test.templatePath, templatePath);
  }

  @Test
  public void setOutputPathTest() {
    Assert.assertNull(test.outputPath);
    test.setOutputPath(outputPath);
    Assert.assertNotNull(test.outputPath);
    Assert.assertEquals(test.outputPath, outputPath);
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(test.equals(test2));
    Assert.assertFalse(test.equals(null));
    test2.setTemplateEditor(new TemplateEditor(filePath));
    Assert.assertFalse(test.equals(test2));
    test2.setTemplateEditor(null);
    test2.setTemplatePath(templatePath);
    Assert.assertFalse(test.equals(test2));
    test2.setTemplatePath(null);
    test2.setOutputPath(outputPath);
    Assert.assertFalse(test.equals(test2));
    Assert.assertFalse(test.equals(filePath2));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
    test2.setTemplateEditor(new TemplateEditor(filePath));
    Assert.assertNotEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("AbstractCorrespondenceMaker{" +
        "templateEditor=" + null +
        ", outputPath='" + null + '\'' +
        ", templatePath='" + null + '\'' +
        '}', test.toString());
  }
}