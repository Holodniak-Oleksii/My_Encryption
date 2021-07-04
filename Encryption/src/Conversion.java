
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Клас для переведення String в ArrayList і назад
 *
 * @author Arsak
 */
public class Conversion {

    /**
     * Метод для переведення String у ArrayList
     * Метод перебирає кожен елемент параметра в масив String, який у свою чергу перебирається у ArrayList
     *
     * @param bin рядрок який потрібно перетворити в ArrayList
     * @return повертає ArrayList my заповнений даними із параметра bin
     */
    public static ArrayList<Integer> toMas(String bin) {
        ArrayList<Integer> my = new ArrayList<>();
        String[] ary = bin.split("");
        for (String ary1 : ary) {
            int a = Integer.parseInt(ary1);
            my.add(a);
        }
        return my;
    }

    /**
     * Метод для переведення ArrayList у String 
     * Метод додає кожен елемет ArrayList в рядок 
     * @param str ArrayList який потрібно перетворити в рядок
     * @return повертає String - рядок який складається із всіх елемнів
     * входящого ArrayLis
     */
    public static String MAStoSrt(ArrayList<Integer> str) {
        String a = "";
        for (int i = 0; i < str.size(); i++) {
            String s = Integer.toString(str.get(i));
            a = a + s;
        }
        return a;
    }
}
