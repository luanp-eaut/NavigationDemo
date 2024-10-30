package eaut.it.mobileappdev.navigationdemo;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public abstract class BaseAppbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        Toolbar toolbar = getToobar();
        if(toolbar!=null) {
            toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        }
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        String title = getActivityTitle();

        if (actionBar != null) {
            //set title for activity
            actionBar.setTitle(title);

            //display back button if having parent activity
            if (getParentActivityIntent() != null)
                actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected abstract int getLayoutResourceId();

    protected abstract Toolbar getToobar();

    protected abstract String getActivityTitle();
}
