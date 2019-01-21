import org.openqa.selenium.JavascriptExecutor;

public class util {
    public static void insertJquery(JavascriptExecutor js) {
        String JQUERY_SCRIPT = "https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js";

        js.executeScript("if (!window.jQuery) {var jquery = document.createElement('script'); jquery.type = 'text/javascript';jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';document.getElementsByTagName('head')[0].appendChild(jquery)}");

        //TODO Add check for existing jQuery on page
        js.executeScript( "var jq = document.createElement('script'); jq.type = 'text/javascript'; jq.src = '" +
                JQUERY_SCRIPT + "'; document.getElementsByTagName('head')[0].appendChild(jq);" );
    }
}
