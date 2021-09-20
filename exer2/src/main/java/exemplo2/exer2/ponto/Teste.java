package exemplo2.exer2.ponto;

import java.util.Calendar;

public class Teste {
    public static void main(String[] args) {

        Calendar n =  Calendar.getInstance();
        n.set(Calendar.DAY_OF_WEEK, 1);
        n.set(Calendar.HOUR_OF_DAY, 0);
        n.set(Calendar.MINUTE, 0);
        n.set(Calendar.SECOND, 0);

        System.out.println(n);

        System.out.println(n.getTime());





    }
}
