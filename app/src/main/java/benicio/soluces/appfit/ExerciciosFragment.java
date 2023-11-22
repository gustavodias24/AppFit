package benicio.soluces.appfit;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import benicio.soluces.appfit.databinding.FragmentExerciciosBinding;

public class ExerciciosFragment extends Fragment {
    /*
    *

    1. Tela Inicial/Login:
    Formulário de Login
	-Nome
	-Senha

    2. Tela de Exercícios
    No cabeçalho da página mostrar um "Menu" com "Bem-vindo [Nome do usuário]
    Lista de exercícios com um botão de favorito em cada exercício

    3. Tela de Rotina
    A cada exercício que o usuário favoritar irá cair para a tela de rotina que irá listar todos os exercícios que o usuário favoritou

    *
    * */

    FragmentExerciciosBinding binding;

    public static ExerciciosFragment newInstance(String param1, String param2) {
        ExerciciosFragment fragment = new ExerciciosFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentExerciciosBinding.inflate(getLayoutInflater());

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("usuario", MODE_PRIVATE);
        binding.textBemvindo.setText(String.format(
                "Bem-vindo %s", sharedPreferences.getString("nome", "")
        ));
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
        r.setLayoutManager(new LinearLayoutManager(requireActivity()));
        r.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);
        r.setAdapter(new AdapterExercicios(exercicioModels, requireActivity(), false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}