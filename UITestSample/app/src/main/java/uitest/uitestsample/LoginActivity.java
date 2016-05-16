package uitest.uitestsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusuke on 5/16/16.
 */
@EActivity(R.layout.login_page)
public class LoginActivity extends AppCompatActivity {
    static List<String> userlist = new ArrayList<String>();
    static List<String> passlist = new ArrayList<String>();
    @ViewById(R.id.username)
    EditText usernameArea;
    @ViewById(R.id.password)
    EditText passwordArea;

    @AfterViews
    public void init() {
        userlist.add("user1");
        passlist.add("password");
    }

    @Click(R.id.login)
    public void login() {
        boolean succeed = false;
        String username = usernameArea.getText().toString();
        String password = passwordArea.getText().toString();
        for(int i = 0; i < userlist.size(); i++) {
            if(username.equals(userlist.get(i)) && password.equals(passlist.get(i))) {
                succeed = true;
            }
        }
        if (succeed) {
            Intent intent = new Intent(this, UserPageActivity_.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "ユーザ名かパスワードが間違っています", Toast.LENGTH_LONG).show();
        }
    }

    @Click(R.id.new_account)
    public void createNewAccount() {
        Intent intent = new Intent(this, RegistrationActivity_.class);
        startActivity(intent);
    }
}
