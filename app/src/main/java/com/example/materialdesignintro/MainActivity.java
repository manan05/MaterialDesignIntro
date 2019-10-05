package com.example.materialdesignintro;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Alert Dialog is used to give alerts to the user

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hello From AlertDialog") //The title of the alert dialog
                .setMessage("I am a generic alert Dialog!") // The message beneath the Title
                .setCancelable(false) //If we want to allow it to be cancellable when pressed elsewhere
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    // can set +ve, -ve, neutral buttons for the response
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Hello, I am a Toast",
                                Toast.LENGTH_SHORT).show();
                    }
                }).create();

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
//                Snackbar.make(view, "Hello From Basic Activity", Snackbar.LENGTH_INDEFINITE) // used to give messages
//                        .setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                            }
//                        }).show();
            }
            //Advantage of snackbar over toast
            // = That we can assign actions to the snackbars but not to the toasts
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
