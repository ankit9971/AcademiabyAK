package ankit.com.acadmiabyak;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    WebView courses;
    ProgressBar Pbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        courses = (WebView) findViewById(R.id.courses);
        Pbar = (ProgressBar) findViewById(R.id.Pbar);
        setTitle("Couses");
        courses.getSettings().setJavaScriptEnabled(true);
        courses.getSettings().setBuiltInZoomControls(true);
        courses.getSettings().setDisplayZoomControls(true);
        courses.loadUrl("https://academia.srmuniv.ac.in/#Page:Course_Confirmation_First_Year");
        courses.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.equalsIgnoreCase("")) {

                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        courses.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                if(progress < 100 && Pbar.getVisibility() == ProgressBar.GONE){
                    Pbar.setVisibility(ProgressBar.VISIBLE);
                }

                Pbar.setProgress(progress);
                if(progress == 100) {
                    Pbar.setVisibility(ProgressBar.GONE);
                }
            }
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.devloper) {
            Toast.makeText(getApplicationContext(),"Ankit kishore",Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.login) {
            Intent i =new Intent(this, LoginPage.class);
            startActivity(i);
            return true;
        } else if (id == R.id.attendance) {
            Intent i =new Intent(this, Attendance.class);
            startActivity(i);
            return true;
        } else if (id == R.id.academic) {
            Intent i =new Intent(this, AcademicPlanner.class);
            startActivity(i);
            return true;
        } else if (id == R.id.batch1) {
            Intent i =new Intent(this, Batch1.class);
            startActivity(i);
            return true;
        } else if (id == R.id.batch2) {
            Intent i =new Intent(this, Batch2.class);
            startActivity(i);
            return true;
        } else if (id == R.id.courses) {
            Intent i =new Intent(this, Courses.class);
            startActivity(i);
            return true;
        } else if (id == R.id.logout)
        {
            courses.loadUrl("https://academia.srmuniv.ac.in/portalLivePage.do?portalLinkName=academia-academic-services&logout=true&serviceurl=https://academia.srmuniv.ac.in");
            Toast.makeText(this,"Yur account has been Logged out",Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.back) {
            Intent i =new Intent(this, MainPage.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
