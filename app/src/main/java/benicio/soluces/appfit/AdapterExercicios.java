package benicio.soluces.appfit;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterExercicios extends RecyclerView.Adapter<AdapterExercicios.MyViewHolder>{

    List<ExercicioModel> lista;
    Context c;

    Boolean favoritado;

    public AdapterExercicios(List<ExercicioModel> lista, Context c, Boolean favoritado) {
        this.lista = lista;
        this.c = c;
        this.favoritado = favoritado;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(c).inflate(R.layout.layout_exercicio, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExercicioModel exercicioModel = lista.get(position);

        Picasso.get().load(Uri.parse(exercicioModel.getImagem())).into(holder.image);

        holder.titulo.setText(exercicioModel.nome);
        holder.descri.setText(exercicioModel.descricao);

        if ( favoritado ){
            holder.favoritar.setVisibility(View.GONE);
        }

        holder.favoritar.setOnClickListener( view -> {
            List<ExercicioModel> listaAntiga = new ArrayList<>();
            if (  ExercicioUtils.loadEx(c) != null) {
                listaAntiga.addAll( ExercicioUtils.loadEx(c));
            }
            listaAntiga.add(exercicioModel);
            ExercicioUtils.saveEx(listaAntiga, c);
            Toast.makeText(c, "Favoritado!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView titulo, descri;

        Button favoritar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            titulo = itemView.findViewById(R.id.titulo);
            descri = itemView.findViewById(R.id.descri);
            favoritar = itemView.findViewById(R.id.favoritar);
        }
    }
}
