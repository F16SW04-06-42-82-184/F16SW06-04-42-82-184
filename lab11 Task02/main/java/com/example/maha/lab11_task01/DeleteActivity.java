package com.example.maha.lab11_task01;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextRoll;
    String d_name;
    String d_roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Intent i = getIntent();
        d_roll = i.getStringExtra("roll");
    }

    public void onDelete(View view) {

        final String name = editTextName.getText().toString().trim();
        final String rollno = editTextRoll.getText().toString().trim();
        if (name.isEmpty()) {
            editTextName.setError("Name Required");
            editTextName.requestFocus();
            return;
        }

        if (rollno.isEmpty()) {
            editTextRoll.setError("Roll Required");
            editTextRoll.requestFocus();
            return;
        }

        class DeleteStudent extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Student student = StdDatabase.getStdDb(getApplicationContext())
                        .stdDao()
                        .getStudent(d_roll);

                // Delete from database
                StdDatabase.getStdDb(getApplicationContext())
                        .stdDao()
                        .delete(student);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_LONG).show();
            }
        }
        DeleteStudent sd = new DeleteStudent();
        sd.execute();
    }

    public void onUpdate(View view) {

        final String name = editTextName.getText().toString().trim();
        final String rollno = editTextRoll.getText().toString().trim();
        if (name.isEmpty()) {
            editTextName.setError("Name Required");
            editTextName.requestFocus();
            return;
        }

        if (rollno.isEmpty()) {
            editTextRoll.setError("Roll Required");
            editTextRoll.requestFocus();
            return;
        }

        class UpdateStudent extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Student student = new Student();
                student.setName(name);
                student.setRollno(rollno);
                // Add to database
                StdDatabase.getStdDb(getApplicationContext())
                        .stdDao()
                        .update(student);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
            }
        }
        UpdateStudent su = new UpdateStudent();
        su.execute();
    }
}
