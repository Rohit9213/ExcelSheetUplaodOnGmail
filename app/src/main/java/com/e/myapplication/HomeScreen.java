package com.e.myapplication;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.e.myapplication.databinding.ActivityHomeScreenBinding;

import java.io.File;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class HomeScreen extends AppCompatActivity {

    private ActivityHomeScreenBinding mbinding;
    ArrayList<StoreVistModel> storevistlist = new ArrayList<>();
    WritableWorkbook workbook;
    String csvFile;
    File file;

    @Override
    protected void onStart() {
        super.onStart();
        isStoragePermissionGranted();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);
        mbinding.txtDate.setText(datetime());
        mbinding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(mbinding.edStorename.getText().toString()))
                {
                    mbinding.edStorename.requestFocus();
                    mbinding.edStorename.setError("Empty Field");
                }

                else
                {
                    savealert();


                }
            }
        });


    }

    private String  datetime()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String strDate = sdf.format(c.getTime());
        return strDate;

    }
    private void savealert()
    {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(HomeScreen.this);
        alertDialog.setTitle("Submit!!");
        alertDialog.setMessage("Are You Want TO Submit");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                try {

                    adddata_inlist();



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void adddata_inlist()
    {

         csvFile = "Visit"+datetime()+".xls";
        File exportdr = new File (Environment.getExternalStorageDirectory(),"/VishalLoading/");
        if (!exportdr.exists()) {
            exportdr.mkdirs();
        }
         file = new File(exportdr,csvFile);

        //file = new File(directory, csvFile);
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            filecreate();

            //closing cursor
            workbook.write();
            workbook.close();
            semdmailonAttatchment();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void filecreate()
    {

        WritableSheet sheet = workbook.createSheet("sheet1", 0);


        try {

            WritableCellFormat format = new WritableCellFormat();
            format.setAlignment(Alignment.CENTRE);
            format.setAlignment(Alignment.getAlignment(550));

           int col = 0;
            int widthInChars = 16;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(col,  0, "Date"));
                col = 2;
                widthInChars = 20;
                sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(2,  0, mbinding.txtDate.getText().toString()));
            col = 0;
            widthInChars = 16;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0,  1, "Store Name"));

            col = 2;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(2,  1,  mbinding.edStorename.getText().toString()));

            col = 0;
            widthInChars = 35;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 3, "Parameters"));
            col = 1;
            widthInChars = 35;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 3, " "));
            col = 2;
            widthInChars = 35;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(2, 3, "Comments/Action PLan/Deficiency"));
            col = 0;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 4, "Store Performane"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 4, "Growth / Degrowth"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 5, "ROCE Targets"));
            col = 0;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 7, "Upcoming New Competition "));
            col = 0;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 9, "Marketing Support"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 9, "Any BTL Support Required"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 10, "Any Bill Buster Required"));
            col = 0;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 12, "Manpower"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 12, "SM / ASM Vacancy"));
            col = 0;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(0, 14, "Infra Issues"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
                sheet.addCell(new Label(1, 14, "Additional Cash TILLs"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 15, "Parking"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 16, "Fire Exits"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 17, "Lift"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 18, "AC"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 19, "Pending Projects job"));
            col = 1;
            widthInChars = 30;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(1, 20, "Any Fixture Requirement"));

            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 4, mbinding.txtGrowthdegrowth.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 5, mbinding.edRocetqarget.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 7, mbinding.edUpcomingnewcompition.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 9, mbinding.edAnybtlsupport.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 10, mbinding.edBillbuster.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 12, mbinding.edSmAsmvacancy.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 14, mbinding.edAdditionalcash.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 15, mbinding.edParking.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 16, mbinding.edFireexit.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 17, mbinding.edLift.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 18, mbinding.edAc.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 19, mbinding.edPendingprojectjob.getText().toString()));
            col = 2;
            widthInChars = 50;
            sheet.setColumnView(col, widthInChars);
            sheet.addCell(new Label(2, 20, mbinding.edAnyfixturerequired.getText().toString()));



        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED )
            {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    private void semdmailonAttatchment()
    {


        Intent intentShareFile = new Intent(Intent.ACTION_SEND);

        intentShareFile.setType(URLConnection.guessContentTypeFromName(file.getName()));
        intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://"+file.getAbsolutePath()));

        //intentShareFile.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(HomeScreen.this,BuildConfig.APPLICATION_ID + ".provider",file));

        //if you need
        //intentShareFile.putExtra(Intent.EXTRA_SUBJECT,"Sharing File Subject);
        //intentShareFile.putExtra(Intent.EXTRA_TEXT, "Sharing File Description");

        startActivity(Intent.createChooser(intentShareFile, "Share File"));
    }


}
