package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L1task2 
{
    public static void main(String[] args)
    {
        try
        {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Обучение\\Java\\L1task2testfile1.txt"));
    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("C:\\Обучение\\Java\\L1task2testfile2.txt"));
    String currentStr="";
    String result = "";
        while ((currentStr = bufferedReader.readLine())!=null)
        {
            result+=currentStr;
        }
        currentStr="";
        while ((currentStr = bufferedReader2.readLine())!=null)
        {
            result+= " + ".concat(currentStr);
        }
        System.out.println(result);
    FileWriter fw = new FileWriter("C:\\Обучение\\Java\\L1task2testfile3.txt"); 
    BufferedWriter bw = new BufferedWriter(fw);
    bw.append(result);
    bw.close();
    }

    
    catch(IOException e)
    {

    }
    }
}
