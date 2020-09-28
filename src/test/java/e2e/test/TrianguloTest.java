package e2e.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class TrianguloTest {

    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        File apk = new File("src/test/resources/app/TrianguloApp.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(DEVICE_NAME, "Android Emulator");
        caps.setCapability(UDID, "emulator-5554");
        caps.setCapability(APP, apk.getAbsolutePath());

        this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void deveValidarUmTrianguloEquilatero() {

        // Arrange
        driver.findElementById("com.eliasnogueira.trianguloapp:id/txtLado1").sendKeys("5");
        driver.findElementById("com.eliasnogueira.trianguloapp:id/txtLado2").sendKeys("5");
        driver.findElementById("com.eliasnogueira.trianguloapp:id/txtLado3").sendKeys("5");

        // Act
        driver.findElementById("com.eliasnogueira.trianguloapp:id/btnCalcular").click();

        // Assert
        String txtResultado = driver.findElementById("com.eliasnogueira.trianguloapp:id/txtResultado").getText();
        Assert.assertEquals("O triângulo é Equilátero", txtResultado);

    }

}
