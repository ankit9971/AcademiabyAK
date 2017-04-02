package ankit.com.acadmiabyak;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends AppCompatActivity{
    Button b1,b2,b3,b4,b5;
    WebView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_page);
        setTitle("Academia by AK");

        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        b3= (Button) findViewById(R.id.b3);
        b4= (Button) findViewById(R.id.b4);
        b5= (Button) findViewById(R.id.b5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainPage.this, LoginPage.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainPage.this, Attendance.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainPage.this, AcademicPlanner.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Batch 1", "Batch 2"};
                new AlertDialog.Builder(MainPage.this).setTitle("Make your selection")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(item == 0)
                            batch1();
                        else if(item == 1)
                            batch2();
                    }
                }).show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainPage.this, Courses.class);
                startActivity(i);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void batch2() {

        Intent i=new Intent(this, Batch2.class);
        startActivity(i);
    }

    private void batch1() {
        Intent i=new Intent(this, Batch1.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page1, menu);
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
        } else if (id == R.id.attendance) {
            Intent i =new Intent(this, Attendance.class);
            startActivity(i);
        } else if (id == R.id.academic) {
            Intent i =new Intent(this, AcademicPlanner.class);
            startActivity(i);
        } else if (id == R.id.batch1) {
            Intent i =new Intent(this, Batch1.class);
            startActivity(i);
        } else if (id == R.id.batch2) {
            Intent i =new Intent(this, Batch2.class);
            startActivity(i);
            return true;
        } else if (id == R.id.courses) {
            Intent i =new Intent(this, Courses.class);
            startActivity(i);
        } else if (id == R.id.logout) {
            logoutacc();
        }

        return super.onOptionsItemSelected(item);
    }
    public void logoutacc()
    {
        logout= (WebView) findViewById(R.id.logout);
        logout.loadUrl("https://academia.srmuniv.ac.in/portalLivePage.do?portalLinkName=academia-academic-services&logout=true&serviceurl=https://academia.srmuniv.ac.in");
        logout.setWebViewClient(new WebViewClient()
        {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.equalsIgnoreCase(""))
                {

                }
                return super.shouldOverrideUrlLoading(view, url);

            }


        });


        logout.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });

        Toast.makeText(this,"Yur account has been Logged out",Toast.LENGTH_SHORT).show();
    }
}
