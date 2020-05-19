/*
 * @author  : Jagepard <jagepard@yandex.ru>
 * @license https://mit-license.org/ MIT
 */

package Behavioral.Mediator;

 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 import java.lang.reflect.InvocationTargetException;
 import java.util.ArrayList;

 import static org.junit.jupiter.api.Assertions.assertEquals;

class MediatorTest {
    private HandlerInterface handler;
    private MediatorInterface mediator;

    @BeforeEach
    void setUp() {
        this.handler  = new Handler();
        this.mediator = new Mediator();
    }

    @Test
    void testNotify() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AbstractListener listener1 = new Colleague1();
        AbstractListener listener2 = new Colleague2();
        AbstractListener listener3 = new Colleague3();

        this.mediator.addListener(listener1, "onEvent");
        this.mediator.addListener(listener2, "onEvent");
        this.mediator.addListener(listener3, "onEvent");

        ArrayList<String> result1 = handShake(handler, mediator, listener1, listener2);
        ArrayList<String> result2 = handShake(handler, mediator, listener2, listener3);
        ArrayList<String> result3 = handShake(handler, mediator, listener3, listener1);

        assertEquals("Behavioral.Mediator.Colleague1: How are you Behavioral.Mediator.Colleague2?", result1.get(0));
        assertEquals("Behavioral.Mediator.Colleague2: Fine, thanks!", result1.get(1));
        assertEquals("Behavioral.Mediator.Colleague2: How are you Behavioral.Mediator.Colleague3?", result2.get(0));
        assertEquals("Behavioral.Mediator.Colleague3: Fine, thanks!", result2.get(1));
        assertEquals("Behavioral.Mediator.Colleague3: How are you Behavioral.Mediator.Colleague1?", result3.get(0));
        assertEquals("Behavioral.Mediator.Colleague1: Fine, thanks!", result3.get(1));
    }

    private static ArrayList<String> handShake(HandlerInterface handler, MediatorInterface mediator, AbstractListener listener1, AbstractListener listener2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return listener1.toGreet(listener2.getClass().getName(), mediator, handler);
    }
}