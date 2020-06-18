package com.example.rubafikri.moviesbyvolly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();
        String url = "http://192.168.1.121/index1.php";


        ListView lv = findViewById(R.id.lv);
        final List<movie> movies = new ArrayList<movie>();
        final MyMovieAdapter nn = new MyMovieAdapter(getApplicationContext(), movies);
        lv.setAdapter(nn);
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i<response.length();i++){
                    try {
                        movie m = new movie();
                        JSONObject ii = response.getJSONObject(i);
                        String essn =ii.getString("dependent_name");
                        m.setTitle(essn);
                        String dept = ii.getString("relationship");
                        m.setRating(dept);
                        movies.add(m);
                    } catch (JSONException e) {
                        e.printStackTrace();
                       }

                }
                nn.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
    }

