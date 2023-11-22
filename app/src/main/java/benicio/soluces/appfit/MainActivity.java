package benicio.soluces.appfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import benicio.soluces.appfit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        sharedPreferences = getSharedPreferences("usuario", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.fazerLogin.setOnClickListener( view -> {
            String login, senha, nomeUsuario;

            login = binding.login.getText().toString();
            senha = binding.senha.getText().toString();
            nomeUsuario = binding.nome.getText().toString();

            if ( login.trim().equals("teste") ){
                if ( senha.trim().equals("1234")){
                    editor.putString("nome", nomeUsuario).apply();
                    Toast.makeText(this, "Login concedido!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }else{
                    Toast.makeText(this, "Senha errada", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Login errado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}