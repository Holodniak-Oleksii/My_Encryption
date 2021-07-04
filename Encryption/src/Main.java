/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Головний клас програми
 * @author Arsak
 */
public class Main {

    private BufferedReader in;
    /**
     * Метод у якому виконується основна логіка програми
     * Тобто цикл у якому кростувач може зашифрувати і дешифрувати повідомлення різними способами 
     * а також за потреби перервати роботу програми 
     * @param args масив який потрібний для коректної роботи програми 
    */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        String second_menu = "/=======================================\\\n"
                           + "|       1.Зашифрувати вміст файлу       |\n"
                           + "|       2.Зашифрувати повідомлення      |\n"
                           + "\\=======================================/\n "
                + "----> ";

        FileWork work = new FileWork();
        BIN bin = new BIN();
        Caesar emperor = new Caesar();
        HEX hex = new HEX();
        Conversion transl = new Conversion();
        boolean run = true;
        while (run) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
            System.out.print(" /========================================\\\n"
                    + "/                   МЕНЮ                   \\\n"
                    + "|==========================================|\n"
                    + "|            1.Зашифрувати файл            |\n"
                    + "|            2.Розшифрувати файл           |\n"
                    + "|         3.Зашифрувати кодом Цезаря       |\n"
                    + "|         4.Розшифрувати код Цезаря        |\n"
                    + "|                 0.Вихід                  |\n"
                    + "============================================\n----> ");
            String name = in.readLine();
            try {
                switch (name) {
                    case ("0"):
                        run = false;
                        break;
                    case ("1"):
                        System.out.print(second_menu);
                        String line = "";
                        String key = "";
                        String choose = in.readLine();
                        if (choose.equals("1")) {
                            System.out.print("Введіть шлях до файлу який потрібно зашифрувати: ");
                            String strin = in.readLine();
                            line = work.printFile(strin);
                            System.out.print("Введіть ключове слово: ");
                            key = in.readLine();
                        }
                        if (choose.equals("2")) {
                            System.out.print("Введіть повідомлення: ");
                            line = in.readLine();
                            System.out.print("Введіть ключове слово: ");
                            key = in.readLine();
                        }
   
                        byte[] inp = line.getBytes(StandardCharsets.UTF_8); // getBytes метод який перетворює віхдне значення у масив байтів
                        String bin_line = bin.convertByteArraysToBinary(inp);

                        byte[] input = key.getBytes(StandardCharsets.UTF_8);
                        String bin_key = bin.convertByteArraysToBinary(input);

                        ArrayList<Integer> code_line = new ArrayList<Integer>();
                        code_line = transl.toMas(bin_line);

                        ArrayList<Integer> code_key = new ArrayList<Integer>();
                        code_key = transl.toMas(bin_key);

                        ArrayList<Integer> encryption = new ArrayList<Integer>();
                        int nan = 0;
                        int leni = 0;
                        if (code_line.size() < code_key.size()) {
                            System.out.println("Кодове слово має бути менше за повідомлення");
                        } else {
                            int max_ele = Math.max(code_line.size(), code_key.size());
                            for (int r = 0; r != max_ele; r++) {
                                if (nan > code_line.size() - 1) {
                                    if (nan < max_ele) {
                                        nan = 0;
                                    }
                                }
                                if (leni > code_key.size() - 1) {
                                    if (leni < max_ele) {
                                        leni = 0;
                                    }
                                }
                                if (code_line.get(nan) == code_key.get(leni)) {
                                    encryption.add(0);
                                }
                                if (code_line.get(nan) != code_key.get(leni)) {
                                    encryption.add(1);
                                }
                                nan++;
                                leni++;
                            }
                            String hexString = hex.BinToHex(encryption);
                            System.out.print("Введі шлях для збереження шифру: ");
                            String path = in.readLine();
                            work.addToFile(hexString, path);
                        }
                        break;

                    case ("2"):
                        System.out.print("Введіть шлях до файлу із шифром: ");
                        String way = in.readLine();

                        System.out.print("Введіть ключове слово: ");
                        String key_word = in.readLine();
                        byte[] Mas_bin_key = key_word.getBytes(StandardCharsets.UTF_8);
                        ArrayList<Integer> Mas_key = transl.toMas(bin.convertByteArraysToBinary(Mas_bin_key));
                        String hexTO_Str = hex.HexToBin(work.printFile(way));
                        ArrayList<Integer> cipher = transl.toMas(hexTO_Str);

                        ArrayList<Integer> decryption = new ArrayList<Integer>();
                        int n = 0;
                        int l = 0;
                        int max_mas_derty = Math.max(cipher.size(), Mas_key.size());
                        for (int c = 0; c != max_mas_derty; c++) {
                            if (l > cipher.size() - 1) {
                                if (l < max_mas_derty) {
                                    l = 0;
                                }
                            }
                            if (n > Mas_key.size() - 1) {
                                if (n < max_mas_derty) {
                                    n = 0;
                                }
                            }
                            if (cipher.get(l) == Mas_key.get(n)) {
                                decryption.add(0);
                            }
                            if (cipher.get(l) != Mas_key.get(n)) {
                                decryption.add(1);
                            }
                            l++;
                            n++;
                        }
                        String str_code = bin.binToText(transl.MAStoSrt(decryption));
                        System.out.println("Розшифрований вміст файлу: " + str_code);
                        break;

                    case ("3"):
                        String stroka = "";
                        String Shleh = "";
                        System.out.print(second_menu);
                        String cho = in.readLine();
                        if (cho.equals("1")) {
                            System.out.print("Введіть шлях до файлу який потірібно зашифрувати: ");
                            String str = in.readLine();
                            stroka = work.printFile(str);
                        }
                        if (cho.equals("2")) {
                            System.out.print("Введіть повідомлення: ");
                            stroka = in.readLine();
                        }
                        System.out.print("Введі шлях для збереження шифру: ");
                        Shleh = in.readLine();
                        work.addToFile(emperor.Caesar_encoder(stroka), Shleh);

                        break;

                    case ("4"):
                        System.out.print("Введіть шлях до файлу із шифром: ");
                        String codik = in.readLine();
                        System.out.println("Розшифроване повідомлення: " + emperor.Caesar_decoder(work.printFile(codik)));

                        break;
                }
            } catch (FileNotFoundException e) {
                System.out.print("Виникла помлика, перевірте введені дані\n");
            } catch (NumberFormatException c) {
                System.out.print("Виникла помлика, перевірте введені дані\n");
            } catch (ArrayIndexOutOfBoundsException v) {
                System.out.print("Виникла помлика, перевірте введені дані\n");
            }
        }
    }
}
