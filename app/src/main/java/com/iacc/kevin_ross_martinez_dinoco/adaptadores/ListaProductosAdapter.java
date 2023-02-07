package com.iacc.kevin_ross_martinez_dinoco.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iacc.kevin_ross_martinez_dinoco.R;
import com.iacc.kevin_ross_martinez_dinoco.VerActivity;
import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

import java.util.ArrayList;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder> {

    // Constructor
    ArrayList<Productos> listaProductos;

    public ListaProductosAdapter(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_productos, null, false);
        return new ProductoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.viewNombre.setText(listaProductos.get(position).getNombre());
        holder.viewPlanta.setText(listaProductos.get(position).getPlanta());
        holder.viewCantidad.setText(listaProductos.get(position).getCantidad());
        holder.ViewFecha.setText(listaProductos.get(position).getFecha());


    }

    @Override
    public int getItemCount() {
       return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewPlanta, viewCantidad, ViewFecha;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewPlanta = itemView.findViewById(R.id.viewPlanta);
            viewCantidad = itemView.findViewById(R.id.viewCantidad);
            ViewFecha = itemView.findViewById(R.id.viewFecha);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaProductos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });


        }
    }
}
