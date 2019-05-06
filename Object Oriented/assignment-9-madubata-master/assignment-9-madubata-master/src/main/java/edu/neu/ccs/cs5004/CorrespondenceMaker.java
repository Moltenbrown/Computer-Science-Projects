package edu.neu.ccs.cs5004;

/**
 * Represents the correspondence maker, which extends abstract correspondence maker.
 *
 * @author Goch.
 */
public class CorrespondenceMaker extends AbstractCorrespondenceMaker{

  /**
   * Creates an empty abstract correspondence maker.
   */
  public CorrespondenceMaker() {super();}

  /**
   * {@inheritDoc}.
   */
  @Override
  public void Correspondence(String templateFilePath, String outputFolderPath,
      String csvFilePath) throws Exception {

    this.setTemplateEditor(new TemplateEditor(csvFilePath));
    this.setOutputPath(outputFolderPath);
    this.setTemplatePath(templateFilePath);

    this.templateEditor.createFilesFromTemplate(this.templatePath, this.outputPath);
  }
}
