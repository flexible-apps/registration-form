package jfoenix.controls;


import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

/**
 * Converts the CSS for -fx-dialog-transition items into DialogTransition.
 * it's used in JFXDialog.
 *
 * @author Shadi Shaheen
 * @version 1.0
 * @since 2016-03-09
 */
public class DialogTransitionConverter extends StyleConverter<String, JFXDialog.DialogTransition> {
    // lazy, thread-safe instatiation
    private static class Holder {
        static final DialogTransitionConverter INSTANCE = new DialogTransitionConverter();
    }

    public static StyleConverter<String, JFXDialog.DialogTransition> getInstance() {
        return Holder.INSTANCE;
    }

    private DialogTransitionConverter() {
    }

    @Override
    public JFXDialog.DialogTransition convert(ParsedValue<String, JFXDialog.DialogTransition> value, Font not_used) {
        String string = value.getValue();
        try {
            return JFXDialog.DialogTransition.valueOf(string);
        } catch (IllegalArgumentException | NullPointerException exception) {
            return JFXDialog.DialogTransition.CENTER;
        }
    }

    @Override
    public String toString() {
        return "DialogTransitionConverter";
    }
}
