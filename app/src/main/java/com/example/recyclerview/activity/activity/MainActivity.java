package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filmes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filmes> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();


        //Configuar adapter

        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // metodo para otimizar o recyclerview
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //definido eventos cliques;
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filmes filmes = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),"Item pressionado: " + filmes.getTituloFilme(),Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filmes filmes = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),"Click longo: " +filmes.getTituloFilme() ,Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }

            )

        );

    }

    public void criarFilmes(){
        Filmes filmes = new Filmes("Homem aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilmes.add(filmes);

        filmes = new Filmes("Mulher maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Liga da Justiça", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Capitao america", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("it A coisa", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Rock", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Missao Impossivel", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("SUperman", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("La casa de Papel", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Chaves", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Lucy", "Fantasia", "2017");
        this.listaFilmes.add(filmes);


        filmes = new Filmes("Indiana Jones", "Fantasia", "2017");
        this.listaFilmes.add(filmes);

    }

}
