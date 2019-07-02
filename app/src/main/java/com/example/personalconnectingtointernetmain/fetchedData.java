package com.example.personalconnectingtointernetmain;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*Created by Richard Luomy 01/07/2019
* This is a java thread to carry out the background process of connecting to the internet
* The java class extends AsyncTask which must  contain three parameters
 */
public class fetchedData extends AsyncTask<Void, Void, Void> {
    String Data="";
    String singleParsed = "";
    String dataParsed = "";
/*The 'singleParsed' variable created represents every JSONObject
* The 'dataParsed' variable created represents the entire data in the whole JSONArray
*/

//Implement the methods for doInBackground and onPostExecute
//Changes to the UI cannot be implemented from the doInBackground method
    @Override
    protected Void doInBackground(Void... voids) {
        try {
// Create an new URL and pass in the api web address
            URL url = new URL("https://api.myjson.com/bins/j8803");
// Instantiate the url with a HttpURLConnection to be open
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
// InputStream is a stream passed only in the connection which enables us to read and write data of the connection
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//BufferReader reads data retrieved by the connection in the InputStream
            String line = "";
            while (line !=null){
                line = bufferedReader.readLine();
//A new 'line' string is created and is assigned the read data in BufferReader
                Data = Data+line;
//The line above 'populates' the JSON response with the content of the line string
//The String 'Data' represents the JSON response
            }
            JSONArray JA = new JSONArray(Data);
//The line above indicates that the content of Data is a JSON object
            for (int i=0; i<JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
//The above lines of code creates a for loop to read every data of every JSONObject in the JSONArray
                singleParsed =  "Name: " +JO.get("name") + "\n"+
                                "Department: "+ JO.get("department")+ "\n"+
                                "Major: "+JO.get("major")+"\n"+
                                "Minor: "+JO.get("minor")+"\n";
//The above line of code describes the format in which the data will be displayed, it is just an alternative to the custom listview method

                dataParsed = dataParsed + singleParsed + "\n";
//The above line of code passes the format in the 'singledParsed' to all JSONObjects in the entire JSONArray
            }
// Don't forget your try/catch
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
//Changes to the UI can be made from this activity in the onPostExecute method
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.fetchedData.setText(dataParsed);
//The above line invokes dataParsed to be displayed in the fetchedData
    }
}


