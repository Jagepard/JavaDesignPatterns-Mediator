/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

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
            listener1.toGreet(listener2.getClass().getName(), mediator, handler);
            listener2.toGreet(listener3.getClass().getName(), mediator, handler);
            listener3.toGreet(listener1.getClass().getName(), mediator, handler);
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
