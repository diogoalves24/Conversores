package com.example.conversores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter_GridView extends BaseAdapter {

    ArrayList opcoes = new ArrayList();
    Context context;

    public Adapter_GridView(Context context) {
        this.context = context;
        opcoes.add("Moeda");
        opcoes.add("Temperatura");
        opcoes.add("Tempo");
        opcoes.add("Velocidade");
    }

    public int getCount() {
        return opcoes.size();
    }

    public Object getItem(int position) {
        return opcoes.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView opcao;

        public ViewHolder(View v) {
            opcao = v.findViewById(R.id.tv_opcao);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        View row = convertView;

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.texto_gridview, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        holder.opcao.setText((String) opcoes.get(position));

        return row;
    }
}
