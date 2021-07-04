
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Клас для роботи із файлами, а саме читання, створення і записування 
 * @author Arsak
 */
public class FileWork {
    private static BufferedReader inn;
    /**
     * Метод який читає файл у кодуванні UTF-8 і поветає його зміст 
     * @param path шллях до файлу
     * @return поветрає зміст файлу
     */

    public static String printFile(String path) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String str = "";
            inn = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
            while (inn.ready()){
                String s = inn.readLine();
                str += s;
            }
            inn.close();
        return str;
    }

    /**
     * Метод який додає у файл по вказаному шляху повідомлення якщо файла немає по даному  шляху
     * то метод ствоює файл і добаляє у нього іноформацію
     * @param x іформація яку потрібно записати
     * @param path шлях до файлу у який потрібно записати
     */
    public static void addToFile(String x, String path){
        try {
            File file = new File(path);
            if (!file.exists()){
                file.createNewFile();
            PrintWriter line = new PrintWriter(file,"UTF-8"); 
            line.print(x);
            line.close();
            }
        }catch (IOException e){
            System.out.println(e);
        }
        
    }
}
