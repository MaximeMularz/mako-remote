package hack4kids.makomermaidsremote;

import android.app.Activity;
import android.app.RemoteInput;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class MyActivity  extends Activity {

    private TextView mTextView;
    // Key for the string that's delivered in the action's intent
    private static final String EXTRA_VOICE_REPLY = "extra_voice_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        stub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoteInput remoteInput = new RemoteInput.Builder(EXTRA_VOICE_REPLY)
                        .setLabel("Respond")
                        .build();
            }
        });

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);

                //Log.d(TAG, "TextView: " + mTextView.getText() + " view=" + mTextView);
            }
        });
    }
}