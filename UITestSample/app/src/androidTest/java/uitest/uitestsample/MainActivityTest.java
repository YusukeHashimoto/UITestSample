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
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
/**
 * Created by yusuke on 5/8/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity_> mActivityRule = new ActivityTestRule<>(MainActivity_.class);

    @Test
    public void testDecToHex() {
        onView(withId(R.id.edit_text)).perform(typeText("32"));
        onView(withId(R.id.dec_to_hex)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("0x20")));
    }

    @Test
    public void testHexToDec() {
        onView(withId(R.id.edit_text)).perform(typeText("3b"));
        onView(withId(R.id.hex_to_dec)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("59")));
    }
}
