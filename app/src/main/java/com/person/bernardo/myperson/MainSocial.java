package com.person.bernardo.myperson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainSocial extends AppCompatActivity {

    Pessoa receivePessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_social);

        Intent intent = getIntent();
        receivePessoa = (Pessoa) intent.getSerializableExtra("proxPessoa");
        pegarDados();
    }

    public String editTextToString(EditText txt) {
        // definir dados
        String resp = "";
        if (txt != null) {
            resp = txt.getText().toString();
        } else {
            resp = "";
        }
        return (resp);
    }// end converteTexto( )

    public void pegarDados() {

        Button save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText facebook = findViewById(R.id.facebook);
                String face = editTextToString(facebook);
                receivePessoa.setFacebook(face);

                EditText instagram = findViewById(R.id.instagram);
                String insta = editTextToString(instagram);
                receivePessoa.setInstagram(insta);

                EditText linkedin = findViewById(R.id.linkedin);
                String link = editTextToString(linkedin);
                receivePessoa.setLinkedIn(link);

                EditText spotify = findViewById(R.id.spotify);
                String spot = editTextToString(spotify);
                receivePessoa.setSpotify(spot);

                EditText twitter = findViewById(R.id.twitter);
                String twit = editTextToString(twitter);
                receivePessoa.setTwitter(twit);

                EditText youtube = findViewById(R.id.youtube);
                String yout = editTextToString(youtube);
                receivePessoa.setYoutube(yout);
            }// end onClick( )
        });
    }

    public void terceiraTela(View view) {
        // criando a intent para a terceira tela com RecycleView
        Intent terceiraTela = new Intent(this, RecyclerViewActivity.class);
        terceiraTela.putExtra("pessoa2", receivePessoa);

        System.out.println(receivePessoa.getNome());
        System.out.println(receivePessoa.getTelefone());
        System.out.println(receivePessoa.getEmail());
        System.out.println(receivePessoa.getEndereco());
        System.out.println(receivePessoa.getFacebook());
        System.out.println(receivePessoa.getInstagram());
        System.out.println(receivePessoa.getLinkedIn());
        System.out.println(receivePessoa.getTwitter());
        System.out.println(receivePessoa.getSpotify());
        System.out.println(receivePessoa.getYoutube());

        // iniciando
        startActivity(terceiraTela);
    }
}