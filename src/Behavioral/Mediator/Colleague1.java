/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Colleague1 implements ListenerInterface {
    public void onEvent()
    {
        System.out.printf("%s\n", "Colleague1: reacts on notify");
    }
}
