package cl.vicentepc.wine.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.vicentepc.wine.R;
import cl.vicentepc.wine.models.Wine;

public class MainActivity extends AppCompatActivity {

    private WinesFragment winesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        winesFragment = (WinesFragment) getSupportFragmentManager().findFragmentById(R.id.winesFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_wine);

                ImageButton button = dialog.findViewById(R.id.saveWineBtn);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText inputName = dialog.findViewById(R.id.wineNameEt);
                        EditText inputAge = dialog.findViewById(R.id.wineYearEt);
                        EditText inputType = dialog.findViewById(R.id.wineTypeEt);

                        String name = inputName.getText().toString();
                        String year = inputAge.getText().toString();
                        String type = inputType.getText().toString();

                        if (name.trim().length() > 0) {

                            Wine wine = new Wine();
                            wine.setWineName(name);
                            wine.setWineYear(year);
                            wine.setWineType(type);

                            wine.save();

                            Log.e("SAVE", String.valueOf(wine));

                            winesFragment.updateList(wine);
                        }

                        dialog.dismiss();

                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
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
