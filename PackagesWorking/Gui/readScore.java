package Gui;

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
            File file = new File("highscore.txt");
            
            FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("highscore.txt");
			} catch (IOException e1) {
				System.out.println("Could not write to file");
			}
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(0);
            printWriter.close();

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
