package benicio.soluces.appfit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ExercicioUtils {

    public static final String nome_prefs = "ex_prefs";
    public static final String ex_nome = "ex_nome";

    public static void saveEx (List<ExercicioModel> lista , Context c){
        SharedPreferences preferences = c.getSharedPreferences(nome_prefs, Context.MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = preferences.edit();

        Gson gson = new Gson();

        editor.putString(ex_nome , gson.toJson(lista) ).apply();
    }

    public static List<ExercicioModel> loadEx(Context c){
        SharedPreferences preferences = c.getSharedPreferences(nome_prefs, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        Type type = new TypeToken<List<ExercicioModel>>(){}.getType();

        return gson.fromJson(preferences.getString(ex_nome, ""), type);
    }

}
