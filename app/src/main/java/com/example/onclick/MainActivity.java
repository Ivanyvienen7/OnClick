package com.example.onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Atributos -- Variables
    //Atributos que representan cada elemento visual que diseñen
    //Nota: elemento visual que van a usar por codigo
    private TextView TxtResultado;
    private Button BtnInvertir;
    private EditText TBNombre, TBCelular;

    //Atributos de clase
    private String nombre;
    private int celular;

    //Metodos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        /*
        Para configurar al boton y decirle que este pendiente al evento click
        que se haga sobre el boton usamos un metodo del tipo SETTER......
        y en realidad ustedes quieren configurar un concepto llamado
        Listener -- algo que esta pendiente a que pase cierto el
         */
        BtnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        /*
        definen el enlace de sus variables o atributos con sus
        componentes visuales que han diseñado en pantalla
        Inicializando sus vistas -- referencia de un View a una variable
         */
        TxtResultado = findViewById(R.id.TxtResultado);
        TBNombre = findViewById(R.id.TBNombre);
        TBCelular = findViewById(R.id.TBCelular);
        BtnInvertir = findViewById(R.id.BtnInvertir);
    }

    private void obtenerInformacionUsuario(){
        /*
        Para obtener la informacion que el usuario introduce en los campos de texto.
        Ustedes van a obteer esos valores del atributo TEXT que esta presente en el
        diseñador de ese componente, y para obtener algo  en POO con JAVA se usa su
        buen amigo GETTER obtener te
         */
        nombre=TBNombre.getText().toString();
        String celularText = TBCelular.getText().toString();
        celular = Integer.parseInt(celularText);
    }

    private void invertirNumero(){
        //Celular : 789456
        //Invertido : 654987
        int resto = 0, invertido = 0;
        while( this.celular > 0 ){
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        TxtResultado.setText("Valor Invertido : " +invertido);
    }

    @Override
    public void onClick(View view) {
        obtenerInformacionUsuario();
        invertirNumero();
    }
}