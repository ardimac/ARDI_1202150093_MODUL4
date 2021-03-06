package com.example.airys.ardi_1202150093_modul4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class Cari extends AppCompatActivity {

    private EditText edt_Cari;
    private Button btn_Cari;
    private ImageView iv_Cari;
    private ProgressDialog progressDialog;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        //deklarasi

        edt_Cari = (EditText) findViewById(R.id.id_cari_gambar);
        btn_Cari = (Button) findViewById(R.id.id_btn_cari);
        iv_Cari = (ImageView) findViewById(R.id.id_iv_cari);


    }

    public void cariGambar(View view) {
        text = edt_Cari.getText().toString();
        //Mengubah EditText ke dalam bentuk String
        if (text.isEmpty()) {
            Toast.makeText(this, "Masukkan URL gambar terlebih dahulu", Toast.LENGTH_LONG).show();
            //Jika kosong muncul toast
        } else {
            new LoadGambar().execute(text);
            //Jika ada isinya dan itu string maka akan langsung di eksekusi
        }

    }

    private class LoadGambar extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Cari.this);
            progressDialog.setTitle("Cari Gambar");
            progressDialog.setMessage("Loading Gambar");
            progressDialog.setIndeterminate(false);
            progressDialog.show();

            //eksekusi progress dialog sebelum method onPostExecute dijalankan
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;

            //aktivitas dibackground menggunakan AsyncTask
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            iv_Cari.setImageBitmap(bitmap);
            progressDialog.dismiss();

            //eksekusi setImageBitmap setelah method doInBackground dijalankan
        }
    }
}
