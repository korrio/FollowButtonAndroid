package otto.test.co.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    Button mButton1;
    Button mButton2;

    TextView mText1;

    boolean isFollowing = false;
    Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        mButton1 = findViewByIdAndCast(R.id.longButton);
        mButton2 = findViewByIdAndCast(R.id.shortButton);
        mText1 = findViewByIdAndCast(R.id.text1);

        mButton1.setOnClickListener(this);

        initButton();

    }

    public void initButton() {

        mButton1.setBackgroundResource(R.drawable.bg_unselected);
        mButton1.setTextColor(Color.parseColor("#ffffff"));

        // clear state
        mButton1.setSelected(false);
        mButton1.setPressed(false);

        mButton1.setText(Html.fromHtml("&#x2713; FOLLOWING"));

        // change state
        mButton1.setSelected(true);
        mButton1.setPressed(false);

        isFollowing = !isFollowing;
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        if (!isFollowing) {
            mButton1.setBackgroundResource(R.drawable.bg_unselected);
            mButton1.setTextColor(Color.parseColor("#ffffff"));

            // clear state
            mButton1.setSelected(false);
            mButton1.setPressed(false);

            mButton1.setText(Html.fromHtml("&#x2713; FOLLOWING"));

            // change state
            button.setSelected(true);
            button.setPressed(false);
        } else {
            mButton1.setSelected(false);
            mButton1.setPressed(false);

            mButton1.setText("+ FOLLOW");
            mButton1.setBackgroundResource(R.drawable.bg_selected);
            mButton1.setTextColor(Color.parseColor("#2C6497"));

        }

        isFollowing = !isFollowing;

        mText1.setText("select: " + button.getText());
    }

    @SuppressWarnings("unchecked")
    private <T> T findViewByIdAndCast(int id) {
        return (T) findViewById(id);
    }

}
