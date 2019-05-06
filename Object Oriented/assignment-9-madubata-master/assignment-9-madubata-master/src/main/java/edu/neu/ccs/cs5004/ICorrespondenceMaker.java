package edu.neu.ccs.cs5004;

/**
 * Represents an interface for the email/letter creator.
 */
public interface ICorrespondenceMaker {

  /**
   * Creates correspondence using the text of the file located at the template file path.
   * All created correspondence is located in the folder pointed to by the output folder
   * path. Each file in the output folder corresponds with the information from one of
   * the clients in the file located at the csv file path.
   *
   * @param templateFilePath the absolute file path for the template of the correspondence.
   * @param outputFolderPath the absolute file path for the output folder the user wants
   * the correspondence to end up in.
   * @param csvFilePath the absolute file path of the csv file containing all the clients
   * the users wants to create correspondence for.
   */
  void Correspondence(String templateFilePath, String outputFolderPath, String csvFilePath)
      throws Exception;
}
