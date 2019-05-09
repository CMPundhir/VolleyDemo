package com.cmpundhir.cm.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.cmpundhir.cm.volleydemo.model.GithubUserPojo;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MajedarActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.loginTxt)
    TextView loginTxt;
    @BindView(R.id.nameTxt)
    TextView nameTxt;
    @BindView(R.id.locationTxt)
    TextView locationTxt;
    @BindView(R.id.companyNameTxt)
    TextView companyNameTxt;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majedar);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button)
    public void onButtonCLicked(View view){
        String id = editText.getText().toString();
        if(!id.equals("")){
            callVolley(id);
        }else{
            Toast.makeText(this, "Please enter id", Toast.LENGTH_SHORT).show();
        }
    }
    public void callVolley(String id){
        progressBar.setVisibility(View.VISIBLE);
        String url = "https://api.github.com/users/"+id;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GithubUserPojo pojo = gson.fromJson(response,GithubUserPojo.class);
                loginTxt.setText(pojo.getLogin());
                nameTxt.setText(pojo.getName());
                locationTxt.setText(pojo.getLocation());
                companyNameTxt.setText(pojo.getCompany()+"");
                Glide.with(MajedarActivity.this).load(pojo.getAvatarUrl()).into(imageView);
                progressBar.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
