package com.example.buildmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.callback.Callback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;

public class Login extends AppCompatActivity {
    private Button loginButton;

    //Reference Auth0 Balmaceda, L., 2021. auth0-samples/auth0-android-sample. [online] GitHub.
    // Available at: <https://github.com/auth0-samples/auth0-android-sample/blob/master/00-Login/app/src/main/java/com/auth0/samples/LoginActivity.java> [Accessed 9 March 2021].
    private Auth0 auth0;

    public static final String EXTRA_CLEAR_CREDENTIALS = "Psp6agipiDVpP2qhm3yzcfgUoFFS5uRR";
    public static final String EXTRA_ACCESS_TOKEN = "n1_z0NqdRQRVJzHMiVW7oJBN-HyQr3Av2a6BFLPcqPpaHH9NlEldFM2K324XKOwX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        //Button creation for navigation between home screen and house style screen
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login();
                openHomeScreen();
            }
        });
       //Reference Auth0
        auth0 = new Auth0(this);
        //Check if the activity was launched to log the user out
        if (getIntent().getBooleanExtra(EXTRA_CLEAR_CREDENTIALS, false)) {
            logout();
        }
    }
    private void openHomeScreen(){
        Intent navigateToProjectScreen = new Intent(this, MainActivity.class);
        startActivity(navigateToProjectScreen);}

        //Reference Auth0
    private void login() {
        WebAuthProvider.login(auth0)
                .withScheme("buildmate")
                .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
                //.withAudience("dev-omlr1l8b.eu.auth0.com")
                .start(this, new Callback<Credentials, AuthenticationException>() {

                    @Override
                    public void onFailure(@NonNull final AuthenticationException exception) {
                        Toast.makeText(Login.this, "Error: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(@Nullable final Credentials credentials) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra(EXTRA_ACCESS_TOKEN, credentials.getAccessToken());
                        startActivity(intent);
                        finish();
                    }
                });
    }

    //Reference Auth0
    private void logout() {
        WebAuthProvider.logout(auth0)
                .withScheme("demo")
                .start(this, new Callback<Void, AuthenticationException>() {
                    @Override
                    public void onSuccess(@Nullable Void payload) {

                    }

                    @Override
                    public void onFailure(@NonNull AuthenticationException error) {
                        //Log out canceled, keep the user logged in
                        showNextActivity();
                    }
                });
    }
    //Reference Auth0
    private void showNextActivity() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
