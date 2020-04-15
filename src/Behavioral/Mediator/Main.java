/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Main {

    public static void main(String[] args) throws Exception {
        HandlerInterface handler   = new Handler();
        MediatorInterface mediator = new Mediator();
        Colleague1 colleague_1 = new Colleague1();
        Colleague2 colleague_2 = new Colleague2();
        Colleague3 colleague_3 = new Colleague3();

        try {
            mediator.addListener("colleague_1", colleague_1, "onEvent");
            mediator.addListener("colleague_2", colleague_2, "onEvent");
            mediator.addListener("colleague_3", colleague_3, "onEvent");

            colleague_1.todo(mediator, handler);
            colleague_2.todo(mediator, handler);
            colleague_3.todo(mediator, handler);
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
