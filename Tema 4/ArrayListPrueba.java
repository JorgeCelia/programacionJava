/*
 * 
 */

import java.util.ArrayList;

public class ArrayListPrueba {

    public static void main(String[] args) {
        //Declaramos las variables
        ArrayList array = new ArrayList();
        array.add("Buenos días");
        array.add(13);
        array.add(0.5);
        array.add('a');
        array.add(true);
        System.out.println(array);

        System.out.println(array.size());

        System.out.println(array.get(1));
        array.add(1,"texto");
        System.out.println(array);
        System.out.println(array.get(1));

        array.remove(2);
        array.remove(1);
        System.out.println(array.size());

        System.out.println(array);
    }
}
    