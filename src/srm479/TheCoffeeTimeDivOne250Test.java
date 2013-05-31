package srm479;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Tibô
 * Date: 26/05/13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class TheCoffeeTimeDivOne250Test {
    @Test
    public void testFind() throws Exception {
        TheCoffeeTimeDivOne250 tc1 = new TheCoffeeTimeDivOne250();

        int[] arrayOne={1};

        assert(tc1.find(2,arrayOne) == 108);
        /*
        15
{1, 2, 3, 4, 5, 6, 7}
Returns: 261
The stewardess will fill the flask three times overall: once with tea and two times with coffee.

         */
        int[] arrayTwo={1, 2, 3, 4, 5, 6, 7};

        assert(tc1.find(15,arrayTwo) == 261);

    }
}
