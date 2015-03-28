package otto.test.co.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends Activity implements OnClickListener {
    Button mButton1;
    Button mButton2;

    TextView mText1;

    boolean isFollowing = false;
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        activity = this;

        mButton1 = findViewByIdAndCast(R.id.longButton);
        mButton2 = findViewByIdAndCast(R.id.shortButton);
        mText1 = findViewByIdAndCast(R.id.text1);

        mButton1.setOnClickListener(this);
        initButton(true,mButton1);
        //initButton(false,mButton2);
        mButton2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        if (isFollowing) {
            toggleUnfollow(button);
        } else {
            toggleFollowing(button);
        }

        isFollowing = !isFollowing;

        mText1.setText("select: " + button.getText());
    }

    @SuppressWarnings("unchecked")
    private <T> T findViewByIdAndCast(int id) {
        return (T) findViewById(id);
    }

    public void initButton(boolean following,View v) {
        Button button = (Button) v;

        isFollowing = following;

        if (following) {
            toggleFollowing(button);
        } else {
            toggleUnfollow(button);
        }

        //isFollowing = !isFollowing;
    }

    public void toggleFollowing(Button v) {
        v.setTextColor(Color.parseColor("#ffffff"));
        v.setText(Html.fromHtml("&#x2713; FOLLOWING"));

        // change state
        v.setSelected(true);
        v.setPressed(false);

    }

    public void toggleUnfollow(Button v) {
        v.setTextColor(Color.parseColor("#2C6497"));
        v.setText("+ FOLLOW");

        // change state
        v.setSelected(false);
        v.setPressed(false);

    }

}
