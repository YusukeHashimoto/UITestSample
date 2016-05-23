package uitest.uitestsample;

import android.app.Activity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by yusuke on 5/16/16.
 */
@EActivity(R.layout.user_page)
public class UserPageActivity extends Activity {
    @ViewById(R.id.message)
    TextView message;

    @AfterViews
    void init() {
        message.setText(LoginActivity_.LOGIN_MESSAGE);
    }
}
