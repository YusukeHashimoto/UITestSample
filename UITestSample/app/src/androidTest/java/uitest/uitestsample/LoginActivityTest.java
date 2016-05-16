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
    public void loninWithUser1() {
        onView(withId(R.id.username)).perform(typeText("user1"));
        onView(withId(R.id.password)).perform(typeText("password"));
        onView(withId(R.id.login)).perform(click());
        onView((withId(R.id.message))).check(matches(withText("Login succeeded")));
    }

    /**
     * 新しくアカウントを作り、ログインできることを確認
     */
    @Test
    public void loginWithNewUser() {

    }
}
