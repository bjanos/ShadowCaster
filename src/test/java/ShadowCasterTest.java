import app.SCFunctionTypes;
import app.ShadowCaster;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Janos Benyovszki
 * */
public class ShadowCasterTest {

    private static final String TO_OBSCURE = "abc";
    private static final String OBSCURED = "ghi";
    private static final String TO_REVEAL = "123";
    private static final String REVEALED = "+,-";
    private ShadowCaster shadowCaster;

    @Before
    public void setUp() throws Exception {
        shadowCaster = new ShadowCaster();
    }

    @Test
    public void testObscure() {
        assertEquals(shadowCaster.execute(TO_OBSCURE, SCFunctionTypes.OBSCURE), OBSCURED);
    }

    @Test
    public void testReveal() {
        assertEquals(shadowCaster.execute(TO_REVEAL, SCFunctionTypes.REVEAL), REVEALED);
    }

    @After
    public void tearDown() throws Exception {
        shadowCaster = null;
    }
}
