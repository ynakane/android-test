package jp.klab.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class HelloAndroid extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
	
	StringBuffer s = new StringBuffer();
	String       ret = "";
	HttpURLConnection con = null; 
	try {
	    URL url = new URL("http://www.google.com/");
	    con = (HttpURLConnection) url.openConnection();
	    //	    s = con.getResponseMessage();

	    BufferedReader reader =
		new BufferedReader(new InputStreamReader(con.getInputStream()));
	    while (true){
		String line = reader.readLine();
		s.append(line);
		if ( line == null ){
		    break;
		}
	    }
	    
	    ret =  s.substring(15);
	} catch (IOException e) {
	    ret = "fail";
	} finally {
	    if ( con != null ) {
		con.disconnect();
	    }
	}

	TextView v = (TextView) findViewById(R.id.sample_text);
	//	TextView v = new 
	v.setText(ret);
	//        setContentView(s);
    }
}
