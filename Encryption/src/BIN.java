
import java.nio.charset.StandardCharsets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Клас для конверктації бінарних значень в String і навпаки
 * @author Arsak
 */
public class BIN {
/**
 * Метод який перетоює бінарний масив в рядок спрочатку перебирає всі його елемнти у StringBuilder, заодно виконуючи над кожним 
 * логічні операції, а вкінці петвоює тип StringBuilde в String за допомогою метода toString
     * @param input бітовий масив який потрібно перетворити в String
     * @return метод повертає послідовність 0-ів та 1-ць в вигляд String
 */
    public static String convertByteArraysToBinary(byte[] input) {

        StringBuilder result = new StringBuilder();
        for (byte b : input) { // перебираєм кожний елемент із input
            int val = b;
            for (int i = 0; i < 8; i++) {// оскільки байт має 8 бітів, ми проходимо через байт 8 разів
                result.append((val & 128) == 0 ? 0 : 1); // & - логічне "і" (перевіряємо, чи є перше число 0 або 1, якщо 0, то 0, якщо 1, то 1)
                val <<= 1;  //?: - тернарний оператор якщо умова рівна true то виражається перше значення якщо false то виражається друга умова 
                // << побітовий зсув в ліво. В кінці додається нуль
            }
        }
        return result.toString();

    }
/**
 * Метод який перетворює введений користувачем рядок двоїчного коду в текст, а саме принимає рядок
 * розділяє його на 8 символів та добавляє у масив bin переводить всі елементи в байтовий маисв bites розмірністю такою самою як у маcива bin
 * перед тим перевівши кожне значення у двійковий код, потім задопомогою класа StandardCharsets данні переводяться в назад в рякод кодуванням UTF-8
     * @param bins рядок двоїчного коду який потрібно перетворити в текст
     * @return метод повертає розшифрований дівоїчний код у вигляді String
 */

    public static String binToText(String bins) {
        String[] bin = bins.split("(?<=\\G.{8})");//(?<=\\G.{8})-розділяє рядок на 8 символів
        byte[] bites = new byte[bin.length];
        for (int i = 0; i < bin.length; i++) {
            bites[i] = getByte(bin[i]);
        }
        return (new String(bites, StandardCharsets.UTF_8)); 
    }
/**
 * Метод який перетворє String і бінарний рядок, параметр String, тобто рядок який складається із послідовності
 * 0-ів та 1-ць, який принимає метод, спрочатку перебирає рядок посимвольно у масив splitBin і задомогою 
 * математичної формули перетворення числав двійковий код петворє строку у масив бітів
     * @param bin двоїчний код який потрібно перетворити в, рядок символю byte
     * @return метод повертає бінарне значення параметра bin 
 */
    public static byte getByte(String bin) {
        int bite = 0;
        String[] splitBin = bin.split("");
        for (int i = 7; i >= 0; i--) {
            if (splitBin[i].equals("1")) {
                bite = (int) (bite + 1 * Math.pow(2, 7 - i));
            }
        }
        return ((byte) bite);
    }
}
