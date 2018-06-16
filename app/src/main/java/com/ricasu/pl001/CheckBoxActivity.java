package com.ricasu.pl001;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckBoxActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Spinner spinner;
    private TextView displayText;
    private CheckBox checkBox;
    private Button pedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        /*displayText = (TextView) findViewById(R.id.displayText);*/
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        pedir = (Button) findViewById(R.id.pedir);
        spinner =(Spinner) findViewById(R.id.spinner);

        checkBox.setChecked(false);
        if (checkBox.isChecked()){
            Toast.makeText(this, "Se marcó", Toast.LENGTH_SHORT).show();
        }

        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeAction();
            }
        });

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String spinner = (String)parent.getItemAtPosition(pos);
                String mensaje = "El valor es..." + spinner;
                Toast.makeText(Spinner.this, mensaje, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?>arg){

            }
        });

    }

    public void executeAction(){
        String spinner = (String)spinner.getSelected.Item();
        Log.d(TAG, "executeAction", + spinner);
        String mensaje = "El valor es" + spinner;
        resultext.setText(mensaje);

    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){

            case R.id.radioButton1:
                if (checked)
                    Toast.makeText(getApplicationContext(), "¡Parece que estás a Dieta!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(getApplicationContext(), "¡Parece que estás con hambre!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton3:
                if (checked)
                    Toast.makeText(getApplicationContext(), "¡Parece que tienes buen paladar!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void actionExecute(View view){
        int radiobuttonId = radioGroup.getCheckedRadioButtonId();
        if (radiobuttonId == -1){
            Toast.makeText(this, "Falta", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void showDialog(View view){
       /* String americana = (String)Spinner.getSelectedItem();
        String pepperoni = (String)Spinner.getSelectedItem();
        String hawaiana = (String)Spinner.getSelectedItem();
        String meat_lover = (String)Spinner.getSelectedItem();
        String a_lo_pobre = (String)Spinner.getSelectedItem();
        String toxica = (String)Spinner.getSelectedItem();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        if (radioButtonId == R.id.radioButton1){

        }else if (radioButtonId == R.id.radioButton2){

        }else if (radioButtonId == R.id.radioButton3){

        } */

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Confirmación de Pedido");
        alertDialog.setMessage("No sé !!!!!!!!!");
        alertDialog.setCancelable(false); //para que no puedan salir sin poner el boton
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "BACAN",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void showNotification(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Notification notification = new NotificationCompat.Builder(this, "default")
                .setContentTitle("HEY!")
                .setContentText("mensaje")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this,R.color.colorAccent))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notification);
    }



    public void androidCheckBoxClicked(View view){
        switch (view.getId()){

            case R.id.checkBox:
                CheckBox checkBox =(CheckBox) view;
                if (checkBox.isChecked())
                    Toast.makeText(this, checkBox.getText() + " Seleccionado", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.checkBox2:
                CheckBox checkBox2 = (CheckBox) view;
                if (checkBox2.isChecked())
                    Toast.makeText(this, checkBox2.getText() + " Seleccionado", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
