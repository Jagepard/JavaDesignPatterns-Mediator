/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        HandlerInterface handler   = new Handler();
        MediatorInterface mediator = new Mediator();
        AbstractListener listener1 = new Colleague1();
        AbstractListener listener2 = new Colleague2();
        AbstractListener listener3 = new Colleague3();

        try {
            mediator.addListener(listener1, "onEvent");
            mediator.addListener(listener2, "onEvent");
            mediator.addListener(listener3, "onEvent");

            handShake(handler, mediator, listener1, listener2);
            handShake(handler, mediator, listener2, listener3);
            handShake(handler, mediator, listener3, listener1);
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }

    private static void handShake(HandlerInterface handler, MediatorInterface mediator, AbstractListener listener1, AbstractListener listener2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ArrayList<String> result1 = listener1.toGreet(listener2.getClass().getName(), mediator, handler);
        System.out.println(result1.get(0));
        System.out.println(result1.get(1));
    }
}
