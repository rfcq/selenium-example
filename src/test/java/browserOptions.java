import org.rfcq.base.BrowserConfig;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class browserOptions extends BrowserConfig {

    @Parameters({ "regression" })
    @Test
    public void main() {
        System.out.println("Just a test!");
    }
}
