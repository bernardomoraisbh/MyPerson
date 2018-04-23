package com.person.bernardo.myperson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

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
        animalNames.add(contato.getLinkedIn());
        animalNames.add(contato.getInstagram());
        animalNames.add(contato.getYoutube());
        animalNames.add(contato.getSpotify());

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Error in the following line
        adapter = new PessoaAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Do something based on the item click in the RecyclerView
    }
}
