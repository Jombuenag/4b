package com.example.takuma.a4b;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/*IMPLEMENTAR CURSO EN LAS BUSQUEDAS Y MEJORAR LAS COMPROBACIONES DE LAS BUSQUEDAS*/

public class Consultas extends AppCompatActivity {

    private DbHelper myDb;

    CheckBox cbAlumnos, cbProfesores;
    EditText nomBusqueda, cicloBusqueda, cursoBusqueda;
    Button btnBuscar;
    String strBusquedaCicloAlum,strBusquedaNomAlum , strBusquedaCursoAlum;
    String strBusquedaCicloProf, strBusquedaNomProf, strBusquedaCursoProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultas);
        cbAlumnos = (CheckBox)findViewById(R.id.cbAlumnos);
        cbProfesores = (CheckBox)findViewById(R.id.cbProfesores);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        nomBusqueda = (EditText)findViewById(R.id.nomBusqueda);
        cicloBusqueda = (EditText)findViewById(R.id.cicloBusqueda);
        cursoBusqueda = (EditText)findViewById(R.id.cursoBusqueda);
        myDb = new DbHelper(this);
        buscador();
    }

    public void buscador() {
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //SI APRETAMOS EL CHECKBOX DE ALUMNOS
            if(cbAlumnos.isChecked()) {
                strBusquedaNomAlum = String.valueOf(nomBusqueda.getText());
                Cursor cursorDB = myDb.devolverNomAlumnos(strBusquedaNomAlum);
                StringBuffer buffer = new StringBuffer();
                try {
                    if (datosCorrectos() && cursorDB.getCount() == -1) {
                        verDatosBusqueda("Error", "No se ha encontrado ningún dato");
                    }
                    while (cursorDB.moveToNext()) {
                        buffer.append("id :" + cursorDB.getString(0) + "\n");
                        buffer.append("Nombre :" + cursorDB.getString(1) + "\n");
                        buffer.append("Apellidos :" + cursorDB.getString(2) + "\n");
                        buffer.append("Edad :" + cursorDB.getString(3) + "\n");
                        buffer.append("Curso :" + cursorDB.getString(4) + "\n");
                        buffer.append("Ciclo :" + cursorDB.getString(5) + "\n");
                        buffer.append("Nota :" + cursorDB.getString(6) + "\n\n");
                    }
                } catch (SQLiteException ErrorSQL) {
                    Toast.makeText(Consultas.this, "Ha ocurrido un error en la consulta", Toast.LENGTH_SHORT).show();
                    ErrorSQL.printStackTrace();
                }
                //Show all data
                verDatosBusqueda("BUSQUEDA", buffer.toString());
            }
            if(cbAlumnos.isChecked()) {
                strBusquedaCicloAlum = String.valueOf(cicloBusqueda.getText());
                Cursor cursorDB = myDb.devolverCicloAlumnos(strBusquedaCicloAlum);
                StringBuffer buffer = new StringBuffer();
                try {
                    if (datosCorrectos() && cursorDB.getCount() == -1) {
                        verDatosBusqueda("Error", "No se ha encontrado ningún dato");
                    }
                    while (cursorDB.moveToNext()) {
                        buffer.append("id :" + cursorDB.getString(0) + "\n");
                        buffer.append("Nombre :" + cursorDB.getString(1) + "\n");
                        buffer.append("Apellidos :" + cursorDB.getString(2) + "\n");
                        buffer.append("Edad :" + cursorDB.getString(3) + "\n");
                        buffer.append("Curso :" + cursorDB.getString(4) + "\n");
                        buffer.append("Ciclo :" + cursorDB.getString(5) + "\n");
                        buffer.append("Nota :" + cursorDB.getString(6) + "\n\n");
                    }
                } catch (SQLiteException ErrorSQL) {
                    Toast.makeText(Consultas.this, "Ha ocurrido un error en la consulta", Toast.LENGTH_SHORT).show();
                    ErrorSQL.printStackTrace();
                }
                //Show all data
                verDatosBusqueda("BUSQUEDA", buffer.toString());
            }
            if(cbAlumnos.isChecked()) {
                strBusquedaCursoAlum = String.valueOf(cursoBusqueda.getText());
                Cursor cursorDB = myDb.devolverCursoAlumno(strBusquedaCursoAlum);
                StringBuffer buffer = new StringBuffer();
                try {
                    if (datosCorrectos() && cursorDB.getCount() == -1) {
                        verDatosBusqueda("Error", "No se ha encontrado ningún dato");
                    }
                    while (cursorDB.moveToNext()) {
                        buffer.append("id :" + cursorDB.getString(0) + "\n");
                        buffer.append("Nombre :" + cursorDB.getString(1) + "\n");
                        buffer.append("Apellidos :" + cursorDB.getString(2) + "\n");
                        buffer.append("Edad :" + cursorDB.getString(3) + "\n");
                        buffer.append("Curso :" + cursorDB.getString(4) + "\n");
                        buffer.append("Ciclo :" + cursorDB.getString(5) + "\n");
                        buffer.append("Nota :" + cursorDB.getString(6) + "\n\n");
                    }
                } catch (SQLiteException ErrorSQL) {
                    Toast.makeText(Consultas.this, "Ha ocurrido un error en la consulta", Toast.LENGTH_SHORT).show();
                    ErrorSQL.printStackTrace();
                }
                //Show all data
                verDatosBusqueda("BUSQUEDA", buffer.toString());
            }
            //SI APRETAMOS EL CHECKBOX PROFESORES
            if(cbProfesores.isChecked()){
                strBusquedaNomProf = String.valueOf(nomBusqueda.getText());
                Cursor cursorDB = myDb.devolverNomProfesores(strBusquedaNomProf);
                StringBuffer buffer = new StringBuffer();
                try {
                    if (datosCorrectos() && cursorDB.getCount() == -1) {
                        verDatosBusqueda("Error", "No se ha encontrado ningún dato");
                    }
                    while (cursorDB.moveToNext()) {
                        buffer.append("id :" + cursorDB.getString(0) + "\n");
                        buffer.append("Nombre :" + cursorDB.getString(1) + "\n");
                        buffer.append("Apellidos :" + cursorDB.getString(2) + "\n");
                        buffer.append("Edad :" + cursorDB.getString(3) + "\n");
                        buffer.append("Tutor :" + cursorDB.getString(4) + "\n");
                        buffer.append("Ciclo :" + cursorDB.getString(5) + "\n");
                        buffer.append("Despacho :" + cursorDB.getString(6) + "\n\n");
                    }
                } catch (SQLiteException ErrorSQL) {
                    Toast.makeText(Consultas.this, "Ha ocurrido un error en la consulta", Toast.LENGTH_SHORT).show();
                    ErrorSQL.printStackTrace();
                }
                //Show all data
                verDatosBusqueda("BUSQUEDA", buffer.toString());
            }
            if(cbProfesores.isChecked()){
                strBusquedaCursoProf = String.valueOf(cursoBusqueda.getText());
                Cursor cursorDB = myDb.devolverCursoProfesor(strBusquedaCursoProf);
                StringBuffer buffer = new StringBuffer();
                try {
                    if (datosCorrectos() && cursorDB.getCount() == -1) {
                        verDatosBusqueda("Error", "No se ha encontrado ningún dato");
                    }
                    while (cursorDB.moveToNext()) {
                        buffer.append("id :" + cursorDB.getString(0) + "\n");
                        buffer.append("Nombre :" + cursorDB.getString(1) + "\n");
                        buffer.append("Apellidos :" + cursorDB.getString(2) + "\n");
                        buffer.append("Edad :" + cursorDB.getString(3) + "\n");
                        buffer.append("Tutor :" + cursorDB.getString(4) + "\n");
                        buffer.append("Ciclo :" + cursorDB.getString(5) + "\n");
                        buffer.append("Despacho :" + cursorDB.getString(6) + "\n\n");
                    }
                } catch (SQLiteException ErrorSQL) {
                    Toast.makeText(Consultas.this, "Ha ocurrido un error en la consulta", Toast.LENGTH_SHORT).show();
                    ErrorSQL.printStackTrace();
                }
                //Show all data
                verDatosBusqueda("BUSQUEDA", buffer.toString());
                }
            }
        });
    }

    //MOSTRAMOS POR PANTALLA LOS RESULTADOS
    public void verDatosBusqueda(String Title, String Message){
        AlertDialog.Builder verDatosAlumnos = new AlertDialog.Builder(this);
        verDatosAlumnos.setCancelable(true);
        verDatosAlumnos.setTitle(Title);
        verDatosAlumnos.setMessage(Message);
        verDatosAlumnos.show();
        }

    //ASÍ NOS ASEGURAMOS DE TENER LOS DATOS NECESARIOS PARA REALIZAR LA BUSQUEDA
    public boolean datosCorrectos(){
        if(cicloBusqueda.getText().length()<=0 && nomBusqueda.getText().length()<=0 ){
            Toast.makeText(Consultas.this, "Rellena los campos de busqueda porfavor", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            if(cbAlumnos.isChecked()==false || cbProfesores.isChecked()==false){
                return false;
            } else {
                return true;
            }
        }
    }
}
