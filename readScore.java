import java.io.*;


public class readScore{

    public static String read(){
        String score = "";

        try{
            FileReader fileReader = new FileReader("highscore.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            score = bufferedReader.readLine();
            bufferedReader.close();

        }
        catch(IOException e){
            System.out.println("File not found");
        }
        return score;
    }

    public static void setScore(int newScore){
        try{
            if (newScore > Integer.parseInt(read()) ){
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
