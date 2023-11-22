package benicio.soluces.appfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import benicio.soluces.appfit.databinding.ActivityRotinaBinding;
import benicio.soluces.appfit.databinding.FragmentRotinaBinding;

public class RotinaActivity extends AppCompatActivity {
    
    ActivityRotinaBinding binding;
    List<ExercicioModel> listaExercicios;
    AdapterExercicios adapterExercicios ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRotinaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.voltar.setOnClickListener( view -> {
            startActivity(new Intent(getApplicationContext(), ExerciciosActivity.class));
            finish();
        });
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        listaExercicios = new ArrayList<>();
        adapterExercicios = new AdapterExercicios(listaExercicios, getApplicationContext(), true);
        if ( ExercicioUtils.loadEx(getApplicationContext()) != null){
            listaExercicios.addAll(ExercicioUtils.loadEx(getApplicationContext()));
        }

        binding.limpar.setOnClickListener( view -> {
            listaExercicios.clear();
            adapterExercicios.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Limpo!", Toast.LENGTH_SHORT).show();
            ExercicioUtils.saveEx(new ArrayList<>(), getApplicationContext());
        });

        binding.atualizar.setOnClickListener(view -> {
            listaExercicios.clear();
            if ( ExercicioUtils.loadEx(getApplicationContext()) != null){
                listaExercicios.addAll(ExercicioUtils.loadEx(getApplicationContext()));
            }
            adapterExercicios.notifyDataSetChanged();
        });

        RecyclerView r = binding.recyclerFavoritos;
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        r.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);

        r.setAdapter(adapterExercicios);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        listaExercicios.clear();
        if ( ExercicioUtils.loadEx(getApplicationContext()) != null){
            listaExercicios.addAll(ExercicioUtils.loadEx(getApplicationContext()));
        }
        adapterExercicios.notifyDataSetChanged();

    }
}