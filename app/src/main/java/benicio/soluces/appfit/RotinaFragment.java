package benicio.soluces.appfit;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import benicio.soluces.appfit.databinding.FragmentExerciciosBinding;
import benicio.soluces.appfit.databinding.FragmentRotinaBinding;


public class RotinaFragment extends Fragment {
    List<ExercicioModel> listaExercicios;
    AdapterExercicios adapterExercicios ;
    FragmentRotinaBinding binding;

    public static RotinaFragment newInstance(String param1, String param2) {
        RotinaFragment fragment = new RotinaFragment();
        return fragment;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = FragmentRotinaBinding.inflate(getLayoutInflater());
        listaExercicios = new ArrayList<>();
        adapterExercicios = new AdapterExercicios(listaExercicios, requireActivity(), true);
        if ( ExercicioUtils.loadEx(requireActivity()) != null){
            listaExercicios.addAll(ExercicioUtils.loadEx(requireActivity()));
        }

       binding.limpar.setOnClickListener( view -> {
           listaExercicios.clear();
           adapterExercicios.notifyDataSetChanged();
           Toast.makeText(requireActivity(), "Limpo!", Toast.LENGTH_SHORT).show();
           ExercicioUtils.saveEx(new ArrayList<>(), requireActivity());
       });

        binding.atualizar.setOnClickListener(view -> {
            listaExercicios.clear();
            if ( ExercicioUtils.loadEx(requireActivity()) != null){
                listaExercicios.addAll(ExercicioUtils.loadEx(requireActivity()));
            }
            adapterExercicios.notifyDataSetChanged();
        });

        RecyclerView r = binding.recyclerFavoritos;
        r.setLayoutManager(new LinearLayoutManager(requireActivity()));
        r.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);

        r.setAdapter(adapterExercicios);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        listaExercicios.clear();
        if ( ExercicioUtils.loadEx(requireActivity()) != null){
            listaExercicios.addAll(ExercicioUtils.loadEx(requireActivity()));
        }
        adapterExercicios.notifyDataSetChanged();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}