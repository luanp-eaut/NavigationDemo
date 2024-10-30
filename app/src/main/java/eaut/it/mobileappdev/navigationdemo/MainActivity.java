package eaut.it.mobileappdev.navigationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends BaseAppbarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected Toolbar getToobar() {
        return findViewById(R.id.toolbar);
    }

    @Override
    protected String getActivityTitle() {
        return "Main Activity";
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        int page2 = R.id.btn_page2;
        if (id == R.id.btn_page2) {
            intent = new Intent(this, Activity2.class);
            startActivity(intent);
        } else if (id == R.id.btn_page3) {
            intent = new Intent(this, Activity3.class);
            startActivity(intent);
        } else {
            intent = new Intent(this, Activity4.class);
            startActivity(intent);
        }
    }
}