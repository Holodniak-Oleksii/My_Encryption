/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Клас який шифрвує і дишифрує повідомлення шифром Цезаря
 * @author Arsak
 */
public class Caesar {

    /**
     * Метод який приймає рядок і зашифровує його шифром Цезаря
     * Введений параметр переводиться в масив символів char потім береться випадковий крок для шифрації
     * кожний символ переноситься на вказаний крок по байтам все це записується у StringBuilder де першим елементом виступає крок
     * всі інші елементи це зашифроване повдомлення
     * @param txt повідомлення яке потрібно зашифрувати 
     * @return виводить зашифрований рядок 
     */
    public static String Caesar_encoder(String txt) {
        StringBuilder s = new StringBuilder();

        byte random = (byte) (Math.random() * 4 + 1);
        char[] chr = txt.toCharArray();
        s.append((char) random);
        for (byte b = 0; chr.length > b; b++) {
            chr[b] = (char) (chr[b] - random);
            s.append(chr[b]);
        }
        return s.toString();
    }

    /**
     * Метод який дешифрує шифр Цезаря
     * Із введеного параметру переться перший елемент який у свою чергу є зашифрованим кроком
     * Поім всі інші симови дешифруються задомогою цього кроку
     * @param code повідомлення яке потрібно дешифрувати
     * @return поветрає дешифроване повідомлення
     */
    public static String Caesar_decoder(String code) {
        StringBuilder l = new StringBuilder();
        char[] c = code.toCharArray();
        byte random = (byte) c[0];
        for (byte b = 1; c.length > b; b++) {
            c[b] = (char) (c[b] + random);
            l.append(c[b]);
        }
        return l.toString();
    }
}
