package com.example.adaptadores2223;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerFrutas, spinnerFrutasPlus;

    String[] frutas = new String[]{"peras", "manzanas", "plátanos", "uvas", "kiwis", "Piñas"};
    String[] localizacion = new String[]{"Portugal, España y Francia","española e italiana", "Francia y RU", "Canarias, Italia y Turquía", "Peñarroya y Madrid", "Cuba y EEEUU"};
    int[] logos = new int[]{R.drawable.pera,
            R.drawable.manzana,
            R.drawable.platano,
            R.drawable.uva,
            R.drawable.kiwi,
            R.drawable.pin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerFrutas = findViewById(R.id.spinnerFrutas);
        spinnerFrutasPlus = findViewById(R.id.spinnerFrutasPlus);


        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, frutas);

        spinnerFrutas.setAdapter(adaptador);

        spinnerFrutas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Has seleccionado la fruta: " + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //----------
        AdaptadorParaFrutas adaptadorParaFrutas = new AdaptadorParaFrutas(this, R.layout.frutas, frutas);

        spinnerFrutasPlus.setAdapter(adaptadorParaFrutas);


    }

    private class AdaptadorParaFrutas extends ArrayAdapter<String> {

        public AdaptadorParaFrutas(@NonNull Context context, int resource, @NonNull String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarFila(position, convertView, parent);
        }

        private View rellenarFila(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View miFila = inflater.inflate(R.layout.frutas,parent, false);

            TextView titulo = miFila.findViewById(R.id.textViewTitulo);
            ImageView imageView = miFila.findViewById(R.id.imageFruta);
            TextView zona = miFila.findViewById(R.id.textViewZona);

            titulo.setText(frutas[position]);
            imageView.setImageResource(logos[position]);
            zona.setText(localizacion[position]);
            return miFila;
        }


    }

}