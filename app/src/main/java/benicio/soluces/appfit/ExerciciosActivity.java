package benicio.soluces.appfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import benicio.soluces.appfit.databinding.ActivityExerciciosBinding;
import benicio.soluces.appfit.databinding.ActivityMainBinding;

public class ExerciciosActivity extends AppCompatActivity {
    
    ActivityExerciciosBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExerciciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("usuario", MODE_PRIVATE);
        binding.textBemvindo.setText(String.format(
                "Bem-vindo %s", sharedPreferences.getString("nome", "")
        ));

        binding.verRotina.setOnClickListener( view -> {
            startActivity(new Intent(getApplicationContext(), RotinaActivity.class));
            finish();
        });

        List<ExercicioModel> exercicioModels = new ArrayList<>();

        exercicioModels.add(new ExercicioModel("Abdominal", "Deitar e forçar a barriga fazendo movimentos repetidas vezes", "https://www.thesun.co.uk/wp-content/uploads/2021/09/NINTCHDBPICT000679788803.jpg"));
        exercicioModels.add(new ExercicioModel("Flexão de Braço", "Deitar de barriga para baixo e levantar o corpo usando os braços", "https://i.pinimg.com/736x/a1/c6/35/a1c635e8f96700fafca3b2b782432cba.jpg"));
        exercicioModels.add(new ExercicioModel("Agachamento", "Flexionar os joelhos e quadril, como se estivesse sentando em uma cadeira", "https://avatars.mds.yandex.net/i?id=16da3c2a97698ef2dcc38614432da8473720d1df-8244056-images-thumbs&n=13"));
        exercicioModels.add(new ExercicioModel("Corrida", "Correr em alta velocidade, promovendo o condicionamento físico", "https://media.baamboozle.com/uploads/images/617576/1642348222_120715.jpeg"));
        exercicioModels.add(new ExercicioModel("Prancha", "Manter o corpo reto, apoiado nos antebraços e pontas dos pés", "https://i.pinimg.com/originals/5e/e9/9e/5ee99edbb1ca7e00cad5ea39083ae175.jpg"));
        exercicioModels.add(new ExercicioModel("Pular Corda", "Pular sobre uma corda, alternando os pés, para exercitar o corpo", "https://avatars.mds.yandex.net/i?id=82d7685eb96f20136463d5db75eb1158bcd34f69-9181946-images-thumbs&n=13"));
        exercicioModels.add(new ExercicioModel("Levantamento de Peso", "Levantar pesos para fortalecer os músculos", "https://avatars.mds.yandex.net/i?id=93f92070fdfa30f7e1a1325b4ce1022fa62dfee8-8310741-images-thumbs&n=13"));
        exercicioModels.add(new ExercicioModel("Yoga", "Praticar posturas e técnicas de respiração para equilíbrio e flexibilidade", "https://avatars.mds.yandex.net/i?id=1b3d3223da08084480609a3389731bb0ffe47b4f-9211526-images-thumbs&n=13"));
        exercicioModels.add(new ExercicioModel("Caminhada", "Realizar caminhadas para promover a saúde cardiovascular", "https://avatars.mds.yandex.net/i?id=e0414614310df7e4dc18506a72bcd0ea9ff35036-4577816-images-thumbs&n=13"));
        exercicioModels.add(new ExercicioModel("Flexão de Perna", "Flexionar os joelhos, elevando as pernas em direção ao corpo", "https://runnersworld.com.br/wp-content/uploads/sites/4/2017/05/single-leg-pushup_1000.jpg"));
        exercicioModels.add(new ExercicioModel("Bicicleta Ergométrica", "Pedalar em uma bicicleta estacionária para exercitar as pernas e o sistema cardiovascular", "https://blog.hiperfeminina.com/wp-content/gallery/melhor-exercicio-para-perder-barriga_1/9.jpg"));


        RecyclerView r = binding.recyclerExercicios;
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        r.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);
        r.setAdapter(new AdapterExercicios(exercicioModels, getApplicationContext(), false));
    }
}