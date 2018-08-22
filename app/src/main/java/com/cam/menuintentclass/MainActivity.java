package com.cam.menuintentclass;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnGuardar:
                Intent intent = new Intent(MainActivity.this

                        ,FormularioActivity.class);
                intent.putExtra("Datos","Saludos");
                //startActivity(intent); //lanzar otra actividad
                startActivityForResult(intent,123); //lanzar otra actividad y esperar resultado
                //requestCode (segundo parametro) es el valor numerico para identificar el lanzado de la segunda actividad

                break;
            case R.id.mnAcercaDe:
                Toast.makeText(this, "Oton Castillo",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnLlamar:
                //Intent especificos o de accion
                Intent inLlamar= new Intent(Intent.ACTION_DIAL); //Accion de marcado
                //uri parsea que el numero de telefono se ingrese correctamente
                //se le antepone tel: para reconocer que es un numero telefonico
                inLlamar.setData(Uri.parse("tel:23115035"));
                startActivity(inLlamar);
                break;
            case R.id.mnWeb:
                //Intent especificos o de accion
                //Uri parsea que este correcta la URL de la Web
                Uri webpage= Uri.parse("http://www.comp.unanleon.edu.ni");
                Intent inWeb= new Intent(Intent.ACTION_VIEW,webpage); //la accion de mostrar
                startActivity(inWeb);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //todas las actividades lanzadas para esperar resultado regresan a este metodo
        if(requestCode==123) //identificador del lanzado de FormularioActivity  para esperar resultado
            if (resultCode==RESULT_OK) //FormularioActivity mando un Ok o un Cancel
            {
                //data contiene el valor que se regreso desde FormularioActivity
                Toast.makeText(this, data.getStringExtra("Datos")
                        , Toast.LENGTH_SHORT).show();
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
