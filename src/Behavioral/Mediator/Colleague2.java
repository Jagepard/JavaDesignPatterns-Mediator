/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Colleague2 extends Listener {
    public void onEvent(HandlerInterface handler)
    {
        handler.setMessage("Colleague2");
        System.out.printf("%s%s\n", handler.getMessage(), ": reacts on notify");
    }
}
