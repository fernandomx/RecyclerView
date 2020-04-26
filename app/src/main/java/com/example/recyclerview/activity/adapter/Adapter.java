package com.example.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filmes;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filmes>  listaFilmes;

    public Adapter(List<Filmes> lista) {

        this.listaFilmes = lista;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())    //inflar um xml
                .inflate(R.layout.adapter_lista,parent, false);


        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filmes filmes = listaFilmes.get(position);

        holder.titulo.setText(filmes.getTituloFilme());
        holder.genero.setText(filmes.getGenero());
        holder.ano.setText(filmes.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size(); //retorna quantidade de itens que serão exibidos no bindview
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Criando holder da classe
        TextView titulo;
        TextView ano;
        TextView genero;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero );




        }
    }
}
