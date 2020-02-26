
package com.Android_microtask_edicola;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.widget.TextView;
import android.os.*;
import java.net.URL;
import javax.net.ssl.*;
import java.io.InputStream;

public class Android_microtask_edicola extends Activity
{
    /** Chiamato quando l'attività viene creata per la prima volta. */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Crea un oggetto TextView e ne imposta il testo su "Benvenuti in Edicola" 
        TextView  tv = new TextView(this);
        tv.setText("Benvenuti in edicola");
        setContentView(tv);

		Magazines magList = Magazines.getIstance();
		
		// Chiamata https asincrona per la richiesta delle risorse
        AsyncTask.execute(new Runnable() 
        {
			@Override
				public void run() {

					// Create idURL
					URL idEndpoint = new URL("https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/issues/{$publicationId}"); 
					// Create connection
					HttpsURLConnection myConnection = (HttpsURLConnection) idEndpoint.openConnection();
					// Set Header
					myConnection.setRequestProperty("header","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4ZWY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5UkOuAFfUndleHK0");				
					// Get content
					myConnection.setRequestMethod("GET");
					// Receive contents
					if (myConnection.getResponseCode() == 200) {
						// Success
						InputStream responseBody = myConnection.getInputStream();
						maglist.setTitles(responseBody).setAvailability(responseBody.available());
					}
					myConnection.disconnect();
				
					// Create imagesURL
					URL imagesEndpoint = new URL("https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/imagesURL"); 
					// Create connection
					myConnection = (HttpsURLConnection) imagesEndpoint.openConnection();
					// Set Header
					myConnection.setRequestProperty("header","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4ZWY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5UkOuAFfUndleHK0");				
					// Get content
					myConnection.setRequestMethod("GET");
					// Receive contents
					if (myConnection.getResponseCode() == 200) {
						// Success
						InputStream responseBody = myConnection.getInputStream();
						magList.setCovers(responseBody);
					}
					myConnection.disconnect();
				}
			});				
        }



	@Override
    public void onDestroy() {
        super.onDestroy();
        /* ritorna alla home */

        }

}
