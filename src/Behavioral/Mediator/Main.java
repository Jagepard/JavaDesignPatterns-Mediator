/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Main {

    public static void main(String[] args) throws Exception {
        HandlerInterface handler   = new Handler();
        MediatorInterface mediator = new Mediator();

        try {
            mediator.addListener("colleague_1", new Colleague1(), "onEvent");
            mediator.addListener("colleague_2", new Colleague2(), "onEvent");
            mediator.addListener("colleague_3", new Colleague3(), "onEvent");

            mediator.notify("colleague_1", null);
            mediator.notify("colleague_2", handler);
            mediator.notify("colleague_3", handler);
        } catch (Exception e) {
            System.out.printf("Caught exception: %s \n", e.getLocalizedMessage());
        }
    }
}
