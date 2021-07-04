
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Клас який перетворює введене значення в придуману автором власну шістнадцятирічну систему числення
 * суть полягає у придставлені бінарного коду у вигяді різних символів юнікоду
 * @author Arsak
 */
public class HEX {

    /**
     * Метод яки примає зашифрований двоїчний код розбиває його на елемети і переводить в залежності 
     * від елемента в первний двоїчний код
     * @param hexi зашифрований двоїчний код який потібно зашифрувати
     * @return поветрає розшифрований двоїчний код
     */
    public static String HexToBin(String hexi) {
        //System.out.println(hexi);
        StringBuilder str = new StringBuilder();
        String[] ary = hexi.split("");
        //System.out.println(ary);
        for (String ary1 : ary) {
            switch (ary1) {
                case "ы" ->  {
                    str.append("0000");
                }
                case "¬" ->  {
                    str.append("0001");
                }
                case "~" ->  {
                    str.append("0010");
                }
                case "■" ->  {
                    str.append("0011");
                }
                case "☻" ->  {
                    str.append("0100");
                }
                case "☼" ->  {
                    str.append("0101");
                }
                case "$" ->  {
                    str.append("0110");
                }
                case "ᶃ" ->  {
                    str.append("0111");
                }
                case "♞" ->  {
                    str.append("1000");
                }
                case "ɞ" ->  {
                    str.append("1001");
                }
                case "֍" ->  {
                    str.append("1010");
                }
                case "ڜ" ->  {
                    str.append("1011");
                }
                case "☯" ->  {
                    str.append("1100");
                }
                case "☃" ->  {
                    str.append("1101");
                }
                case "⚛" ->  {
                    str.append("1110");
                }
                case "✵" ->  {
                    str.append("1111");
                }
            }
        }
        String Final = str.toString();
        //System.out.println(str);
        return Final;
    }

    /**
     * Метод яки примає ArrayList у якому двоїчний код розбиває на відізки по 4 елемети і переводить в залежності 
     * від відрізка в первний символ юнікоду записуючи все в рядок
     * @param Binary двоїчний код який потібно зашифрувати
     * @return поветрає зашифрований двоїчний код
     */
    public static String BinToHex(ArrayList<Integer> Binary) { 
        Conversion con = new Conversion();
        int Size_mas = Binary.size();
        //System.out.println(Binary);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= Size_mas; i += 5) {
            Binary.add(i, 8);
            Size_mas = Binary.size();
        }
        //System.out.println(Binary);
        String[] f = con.MAStoSrt(Binary).split("8");
        for (int i = 0; i < f.length; i++) {
            switch (f[i]) {
                case "0000": {
                    str.append("ы");
                    break;
                }
                case "0001": {
                    str.append("¬");
                    break;
                }
                case "0010": {
                    str.append("~");
                    break;
                }
                case "0011": {
                    str.append("■");
                    break;
                }
                case "0100": {
                    str.append("☻");
                    break;
                }
                case "0101": {
                    str.append("☼");
                    break;
                }
                case "0110": {
                    str.append("$");
                    break;
                }
                case "0111": {
                    str.append("ᶃ");
                    break;
                }
                case "1000": {
                    str.append("♞");
                    break;
                }
                case "1001": {
                    str.append("ɞ");
                    break;
                }
                case "1010": {
                    str.append("֍");
                    break;
                }
                case "1011": {
                    str.append("ڜ");
                    break;
                }
                case "1100": {
                    str.append("☯");
                    break;
                }
                case "1101": {
                    str.append("☃");
                    break;
                }
                case "1110": {
                    str.append("⚛");
                    break;
                }
                case "1111": {
                    str.append("✵");
                    break;
                }
            }
        }
        String Final = str.toString();
        //System.out.println(str);
        return Final;
    }
}
