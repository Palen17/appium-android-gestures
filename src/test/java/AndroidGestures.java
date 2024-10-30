import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestures {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSessionUsingOptions.initializeDriver();

        //longClickGesture(driver);
        //clickGesture(driver);
        //dragGesture(driver);
        //pinchOpenGesture(driver); //maps
        //pinchCloseGesture(driver); //maps
        //swipeGesture(driver);
        scrollGesture(driver);
    }

    public static void longClickGesture(AppiumDriver driver){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                //"x", 209,
                //"y", 629,
                "duration", 1000
        ));
    }

    public static void clickGesture(AppiumDriver driver){

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        // Java
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void dragGesture(AppiumDriver driver){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
       driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 626,
                "endY", 626
        ));
    }

    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(5000);

        // Java
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 210,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void pinchCloseGesture(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(5000);

        // Java
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 210,
                "top", 470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void swipeGesture(AppiumDriver driver){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

                driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.10
        ));

//        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
//
//        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
////                "left", 100, "top", 100, "width", 600, "height", 600,
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", "up",
//                "percent", 0.75
//        ));
    }

    public static void scrollGesture(AppiumDriver driver){

//        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//
//        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
//
//        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
//                //"left", 100, "top", 100, "width", 200, "height", 200,
//                "elementId", ((RemoteWebElement) element).getId(),
//                "direction", "down",
//                "percent", 1.0
//        ));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //       WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));

        boolean canScrollMore = true;
        while(canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
//                "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }

    }
}
