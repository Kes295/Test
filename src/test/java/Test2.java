import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by oskrynnik on 4/20/2015.
 */
public class Test2 extends ConfigurationManager {
    @Test
    public void testUntitled2() throws Exception {
        //preparation
        Data data = new Data();
        LoginPage loginPage = new LoginPage();
        //test
        Inbox inbox = loginPage.fillInLoginField(data.getLogin())
                .fillInPasswordField(data.getPassword())
                .clickAuth();
        assertTrue(inbox.isAvatarPresent());
    }
}


