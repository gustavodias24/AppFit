package benicio.soluces.appfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import benicio.soluces.appfit.databinding.ActivityHomeBinding;
import benicio.soluces.appfit.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Exercícios", ExerciciosFragment.class)
                .add("Rotina", RotinaFragment.class)
                .create());

        ViewPager viewPager = binding.viewpager;
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = binding.viewpagertab;
        viewPagerTab.setViewPager(viewPager);
    }
}