package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){

        Intent intent =null, chooser=null;
        if (view.getId()==R.id.button_map) {
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:5.015352,7.912776"));
            chooser=Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
        if (view.getId()==R.id.button_market){
            intent = new Intent (android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.nomonkeys.ballblast&hl=en"));
            chooser = Intent.createChooser(intent,"Launch Market");
            startActivity(chooser);
        }
        if(view.getId()==R.id.button_email){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String [] to = {"basseyemmanuel23@gmail.com","Josephofudi@gmail.com", "luomyequa@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a drill mail for testing purpose only");
            intent.putExtra(Intent.EXTRA_TEXT,"Good day this is just an experimental email sent from my app, rely at will.\n It is not a hacksploit, it is not a Spam.\n Thank you");
           intent.setType("message/rfc822");
            chooser= Intent.createChooser(intent,"Send Mail");
            startActivity(chooser);
        }
        if(view.getId()==R.id.button_image){
        Uri imageUri= Uri.parse("android.resource://LuomyEQua.AndroidProjects.drawable/"+R.drawable.birthdaycake);
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM,imageUri );
        intent.putExtra(Intent.EXTRA_TEXT, "Hello,\n This image was sent from my app\nIt is not a spam or a hacksploit");
        chooser = Intent.createChooser(intent,"Send Image");
        startActivity(chooser);
        }

        if(view.getId()== R.id.button){
            File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String [] listOfPictures = pictures.list();
            Uri uri = null;
            ArrayList<Uri> arrayList = new ArrayList<Uri>();
            for(String picture : listOfPictures) {
                uri = Uri.parse("file://" + pictures.toString() + "/" + picture);
                arrayList.add(uri);
            }
                intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, arrayList);
                intent.putExtra(Intent.EXTRA_SUBJECT, "These images were sent from my app");
                chooser = Intent.createChooser(intent, "Send Multiple Images");
                startActivity(chooser);
        }
    }

}
