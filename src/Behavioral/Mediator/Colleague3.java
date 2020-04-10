/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

public class Colleague3 extends Listener {
    public void onEvent()
    {
        System.out.printf("%s\n", "Colleague3: reacts on notify");
    }
}
