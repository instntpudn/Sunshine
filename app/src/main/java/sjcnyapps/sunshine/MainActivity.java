package sjcnyapps.sunshine;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button) findViewById(R.id.searchbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText edittext = (EditText) findViewById(R.id.editText);
                GetWeather(edittext.getText().toString());
            }
        });
    }

    public void GetWeather(String SearchText) {

        String forecastArray[] = {
                "Today - Cold",
                "Tomorrow - Cold"
        };

        ArrayAdapter<String> mForecastAdapter;
        List<String> weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray)
        );

        mForecastAdapter =
                new ArrayAdapter<String>(
                        this,
                        R.layout.weathertext,
                        weekForecast
                );


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mForecastAdapter);

        //new AlertDialog.Builder(this)
        //        .setTitle("Delete entry")
        //        .setMessage(SearchText)
        //        .show();

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
