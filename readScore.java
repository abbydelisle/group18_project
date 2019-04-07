import java.io.*;


public class readScore{
  //private int s = read();
  public static String read(){
    String str = "";
    try{
      FileReader fr = new FileReader("highscore.txt");
      BufferedReader br = new BufferedReader(fr);

      str = br.readLine();
      //System.out.println(str);
      br.close();

    }
    catch(IOException e){
      System.out.println("File not found");
    }
    return str;
  }

  public static void setScore(int point){
    try{
      if (point > Integer.parseInt(read()) ){
        FileWriter fw = new FileWriter("highscore.txt");
        PrintWriter pw = new PrintWriter(fw);

        pw.println(point);
        pw.close();
      }
    }
    catch(IOException e){
      System.out.println("ERROR!");
    }
  }



}
