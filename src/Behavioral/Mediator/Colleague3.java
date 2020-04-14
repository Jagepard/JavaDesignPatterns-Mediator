/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Colleague3 implements ListenerInterface {
    public void onEvent(HandlerInterface handler)
    {
        handler.setMessage("Colleague3");
        System.out.printf("%s%s\n", handler.getMessage(), ": reacts on notify");
    }
}
