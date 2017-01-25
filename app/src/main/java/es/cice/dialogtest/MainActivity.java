package es.cice.dialogtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showPositiveNegativeDialog(View v){
        MyPositiveNegativeDialog myDialog=new MyPositiveNegativeDialog();
        myDialog.show(getFragmentManager(), "myDialog");
    }

    //clase interna
    public static class MyPositiveNegativeDialog extends DialogFragment {
        private Context ctx;



        @Override
        //hay q definir q ha de ocurrir cuando se crea el diálogo
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("My positive Negative Build")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();

                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();

                }
            });
            return builder.create();
        }
    }

}
