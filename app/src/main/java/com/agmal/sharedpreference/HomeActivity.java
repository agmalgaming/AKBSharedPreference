package com.agmal.sharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.agmal.sharedpreference.UtilStatic;
import com.agmal.sharedpreference.UserModel;
import java.util.prefs.Preferences;

import static com.agmal.sharedpreference.Preferences.getRegisteredUser;
import static java.util.prefs.Preferences.*;

public class HomeActivity extends AppCompatActivity {

    private TextView txtKeluar;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        declareView();
        txtKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear Set Preferences
                com.agmal.sharedpreference.Preferences.setLogout(getBaseContext());

                //Pindah Halaman ke Login
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });

    }

    private void declareView() {
        txtKeluar = findViewById(R.id.txt_logout);
        txtName = findViewById(R.id.txtName);

        txtName.setText(getRegisteredUser(getBaseContext()));
    }
}
