package de.jo20046.a782_external_activities;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] items = {"Browser", "Search Campus Bocholt", "Dial", "Call", "Bocholt Map"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.list_menu);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    callBrowser();
                    break;
                case 1:
                    callWebSearch();
                    break;
                case 2:
                    callDial();
                    break;
                case 3:
                    callCall();
                    break;
                case 4:
                    callGeoposition();
                    break;
                default:
                    break;
            }
        });
    }

    public void callBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    public void callWebSearch() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "Campus Bocholt");
        startActivity(intent);
    }

    public void callDial() {
        startActivity(new Intent(Intent.ACTION_DIAL));
    }

    public void callCall() {
        Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
    }

    public void callGeoposition() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo: 51.8398,6.6527?z=15"));
        startActivity(intent);
    }
}