package qubitmobiles.duenna.com.retrofitwithroom.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import qubitmobiles.duenna.com.retrofitwithroom.R;
import qubitmobiles.duenna.com.retrofitwithroom.fragment.TestFragment;

import android.os.Bundle;
import android.widget.FrameLayout;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.fragmentContainer)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.fragmentContainer, new TestFragment())
                    .commit();
        }

    }
}
