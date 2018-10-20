package view.base;

import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bockey on 2017/2/4.
 */
public class EditTextHelper{

    public static void lostFource(EditText editText){
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(true);
    }
    public static void lostFource(List<EditText> editTexts){
        for(EditText editText : editTexts){
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(true);
        }
    }


    private EditText editText;

    public EditTextHelper(EditText editText){
        this.editText = editText;
    }

    public EditTextHelper setEditHintText(String hint) {
        editText.setHint(hint);
        return this;
    }

    public String getEditText() {
        return editText.getText().toString();
    }

    public EditTextHelper setEditTextBackground(int res) {
        editText.setBackgroundResource(res);
        return this;
    }

    public EditTextHelper setInputLength(int length) {
        editText.setFilters(
                new InputFilter[]{
                        new InputFilter.LengthFilter(length)
                });
        return this;
    }

    public EditTextHelper getFource() {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        return this;
    }

    public EditTextHelper lostFource() {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(true);
        return this;
    }

    public EditTextHelper setImOption(ImoptionType type, final IfOnClockDown ifOnClockDown) {
        switch (type){
            case NEXT:
                editText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                break;
            case DOWN:
                editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
                break;
        }

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                ifOnClockDown.onClickDown();
                return false;
            }
        });
        return this;
    }

    public interface IfOnClockDown {
        void onClickDown();
    }

    public enum ImoptionType {
        NEXT,DOWN
    }
}

