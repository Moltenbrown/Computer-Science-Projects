package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Represents an abstract correspondence maker with its details--its template editor as a
 * template editor and the output directory path and the template directory path as strings.
 *
 * @author Goch.
 */
abstract class AbstractCorrespondenceMaker implements ICorrespondenceMaker {
  protected TemplateEditor templateEditor;
  protected String outputPath;
  protected String templatePath;

  /**
   * Creates an empty abstract correspondence maker.
   */
  protected AbstractCorrespondenceMaker() {
    this.templateEditor = null;
    this.outputPath = null;
    this.templatePath = null;
  }

  public TemplateEditor getTemplateEditor() {
    return templateEditor;
  }

  /**
   * Sets the abstract correspondence maker's template editor.
   * @param templateEditor the template editor we are setting the abstract template's editor to.
   */
  public void setTemplateEditor(TemplateEditor templateEditor) {
    this.templateEditor = templateEditor;
  }

  /**
   * Sets the abstract correspondence maker's template editor.
   * @param outputPath the output path we are setting the abstract output path to.
   */
  public void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }

  /**
   * Sets the abstract correspondence maker's template editor.
   * @param templatePath the template path we are setting the abstract template path to.
   */
  public void setTemplatePath(String templatePath) {
    this.templatePath = templatePath;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public abstract void Correspondence(String templateFilePath, String outputFolderPath,
      String csvFilePath) throws Exception;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractCorrespondenceMaker)) {
      return false;
    }
    AbstractCorrespondenceMaker that = (AbstractCorrespondenceMaker) o;
    return Objects.equals(templateEditor, that.templateEditor) &&
        Objects.equals(outputPath, that.outputPath) &&
        Objects.equals(templatePath, that.templatePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(templateEditor, outputPath, templatePath);
  }

  @Override
  public String toString() {
    return "AbstractCorrespondenceMaker{" +
        "templateEditor=" + templateEditor +
        ", outputPath='" + outputPath + '\'' +
        ", templatePath='" + templatePath + '\'' +
        '}';
  }
}
