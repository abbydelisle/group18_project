/**
 * This class reads and writes the highscore on the text file
 */

package Gui;

import java.io.*;


public class Read_Score_Gui{

  /**
   * This returns the current highscore that is recorded on the text file
   * @return the current highscore
   */
  public static String read(){
    String score = "";

    try{
      FileReader fileReader = new FileReader("highscore.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      score = bufferedReader.readLine();
      bufferedReader.close();
      if (score == null){

        FileWriter fileWriter = new FileWriter("highscore.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(0);
        printWriter.close();

        score = "0";

      }

    }
    // if there is error finding a file, then create new, set it default to 0
    catch(IOException e){
      File file = new File("highscore.txt");

      FileWriter fileWriter = null;

			try {
				fileWriter = new FileWriter("highscore.txt");
			}
      catch (IOException e1) {
				System.out.println("Could not write to file");
			}
      PrintWriter printWriter = new PrintWriter(fileWriter);

      printWriter.println(0);
      printWriter.close();
    }
    return score;
  }

  /**
   * This writes the new highscore if old highscore is beat
   * @param newScore the new score from the player
   */
  public static void setScore(int newScore){
    try{
      if (newScore > Integer.parseInt(read()) || read() == null){
        FileWriter fileWriter = new FileWriter("highscore.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(newScore);
        printWriter.close();
      }
    }
    catch(IOException e){
      System.out.println("ERROR!");
    }
  }
}
