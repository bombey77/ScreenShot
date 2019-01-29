package tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Tests extends BaseDriver {

    @Test
    public void connectionTest() {
        System.out.println("Connecting...");
        Assert.assertEquals(true, false);
    }

    @Test
    public void fillTheFieldsTest() {
        System.out.println("Filling the fields...");
    }

    @Test
    public void pressConnectButtonTest() {
        System.out.println("Press the button...");
    }
}
