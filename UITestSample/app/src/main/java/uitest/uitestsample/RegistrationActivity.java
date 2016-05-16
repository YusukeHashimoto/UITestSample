package uitest.uitestsample;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by yusuke on 5/16/16.
 */
@EActivity(R.layout.registration_page)
public class RegistrationActivity extends Activity {
    @ViewById(R.id.username)
    EditText usernameArea;
    @ViewById(R.id.password1)
    EditText passwordArea1;
    @ViewById(R.id.password2)
    EditText passwordArea2;
    @ViewById(R.id.mailaddress)
    EditText mailArea;

    @Click(R.id.register)
    public void register() {
        String username = usernameArea.getText().toString();
        if(username.length() == 0) {
            Toast.makeText(this, "ユーザ名を入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        String password = passwordArea1.getText().toString();
        if(password.length() == 0) {
            Toast.makeText(this, "パスワードを入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        String mailAddress = mailArea.getText().toString();
        if(mailAddress.length() == 0) {
            Toast.makeText(this, "メールアドレス入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(passwordArea2.getText().toString())) {
            Toast.makeText(this, "パスワードを正しく入力してください", Toast.LENGTH_LONG).show();
        }

        LoginActivity_.userlist.add(username);
        LoginActivity_.passlist.add(password);
        finish();
    }
}
