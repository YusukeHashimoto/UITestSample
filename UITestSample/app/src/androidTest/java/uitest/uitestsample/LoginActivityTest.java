package uitest.uitestsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by yusuke on 5/16/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity_> mActivityRule = new ActivityTestRule<>(LoginActivity_.class);

    /**
     * ユーザ名"user1", パスワード"password"でログインできることを確認
     */
    @Test
    public void loginWithUser1() {
        loginWith("user1", "password");
        onView((withId(R.id.message))).check(matches(withText(LoginActivity_.LOGIN_MESSAGE)));
    }

    /**
     * 新しくアカウントを作り、ログインできることを確認
     */
    @Test
    public void loginWithNewUser() {
        String username = "newUser";
        String password = "password";

        onView(withId(R.id.new_account)).perform(click());
        onView(withId(R.id.username)).perform(typeText(username));
        onView(withId(R.id.password1)).perform(typeText(password));
        onView(withId(R.id.password2)).perform(typeText(password));
        onView(withId(R.id.mailaddress)).perform(typeText("newUser@gmail.com"));
        onView(withId(R.id.register)).perform(click());

        loginWith(username, password);
        onView(withId(R.id.message)).check(matches(withText(LoginActivity_.LOGIN_MESSAGE)));
    }

    private void loginWith(String username, String password) {
        onView(withId(R.id.username)).perform(typeText(username));
        onView(withId(R.id.password)).perform(typeText(password));
        onView(withId(R.id.login)).perform(click());
    }
}
