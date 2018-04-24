package com.person.bernardo.myperson;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class RecyclerViewActivity extends AppCompatActivity implements ItemClickListener {

    PessoaAdapter adapter;
    Pessoa contato;
    private List<Pessoa> movieList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        Intent intent = getIntent();
        contato = (Pessoa) intent.getSerializableExtra("pessoa2");

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add(contato.getNome());
        animalNames.add(contato.getTelefone());
        animalNames.add(contato.getEmail());
        animalNames.add(contato.getEndereco());
        animalNames.add(contato.getFacebook());
        animalNames.add(contato.getInstagram());
        animalNames.add(contato.getLinkedIn());
        animalNames.add(contato.getSpotify());
        animalNames.add(contato.getTwitter());
        animalNames.add(contato.getYoutube());


        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // add the decoration to the recyclerView
        SeparatorDecoration decoration = new SeparatorDecoration(this, Color.GRAY, 1.5f);
        recyclerView.addItemDecoration(decoration);

        // Error in the following line
        adapter = new PessoaAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    /*public void whatsapp(String number) {
        contato.setTelefone(number);

        // send contact number
        Uri uri = Uri.parse("smsto:" + number);

        // start intent
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);

        // text type
        sendIntent.setPackage("text/plain");

        // add whatsapp package
        sendIntent.setPackage("com.whatsapp");

        // start activity
        startActivity(Intent.createChooser(sendIntent, ""));
    }// end whatsapp( )*/

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "Linked In nao instalado.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent newActivity;
        switch (position) {
            //facebook
            case 4:
                newActivity = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/" + contato.getFacebook()));
                startActivity(newActivity);
                break;
            //instagram
            case 5:
                Uri uri = Uri.parse("http://instagram.com/_u/" + contato.getInstagram());
                newActivity = new Intent(Intent.ACTION_VIEW, uri);

                newActivity.setPackage("com.instagram.android");

                try {
                    startActivity(newActivity);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/xxx")));
                }
                break;

            //linkedin
            case 6:
                String PACKAGE = "com.linkedin.android";
                PackageManager forms = getPackageManager();
                newActivity = new Intent(Intent.ACTION_VIEW, Uri.parse(contato.getLinkedIn()));
                if (isPackageInstalled(PACKAGE, forms)) {
                    newActivity.setPackage(PACKAGE);
                    startActivity(newActivity);
                }
                break;

            //spotify
            case 7:
                newActivity = new Intent(Intent.ACTION_VIEW, Uri.parse("spotify:track:" + contato.getSpotify()));
                startActivity(newActivity);
                break;

            //twitter
            case 8:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + contato.getTwitter())));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + contato.getTwitter())));
                }
                break;

            //youtube
            case 9:
                newActivity = new Intent(Intent.ACTION_VIEW);
                newActivity.setData(Uri.parse("http://www.youtube.com/user/" + contato.getYoutube()));
                newActivity.setPackage("com.google.android.youtube");
                startActivity(newActivity);
                break;
        }
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
