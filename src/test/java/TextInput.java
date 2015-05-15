import org.openqa.selenium.By;

/**
 * Created by Mandrake on 27.04.2015.
 */
public class TextInput extends Element {
    public TextInput(By by){
        this.by = by;
    }

    public void sendKeys(String value) {
        element().clear();
        element().sendKeys(value);
    }}