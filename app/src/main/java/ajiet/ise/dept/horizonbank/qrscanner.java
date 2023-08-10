package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.util.Size;
import android.widget.EditText;
import android.widget.Toast;


import java.util.concurrent.ExecutionException;

public class qrscanner extends AppCompatActivity {

     EditText qrtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);

      /*

        if(ContextCompat.checkSelfPermission(qrscanner.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
        {
            init();
        }
        else
        {
            ActivityCompat.requestPermissions(qrscanner.this,new String[]{ Manifest.permission.CAMERA},101);
        }
    }
    private  void init()
    {
        cameraProviderListenableFuture=ProcessCameraProvider.getInstance(qrscanner.this);

        cameraProviderListenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    ProcessCameraProvider cameraProvider=cameraProviderListenableFuture.get();
                    bindImageAnalysis(cameraProvider);
                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },ContextCompat.getMainExecutor(qrscanner.this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            init();
        }
        else
            Toast.makeText(qrscanner.this, "Permission denied", Toast.LENGTH_SHORT).show();
    }
    private  void bindImageAnalysis(ProcessCameraProvider processCameraProvider)
    {
        ImageAnalysis imageAnalysis=new ImageAnalysis.Builder().setTargetResolution(new Size(1280,720))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST).build();

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(qrscanner.this), new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(@NonNull ImageProxy image) {
                Image image1=image.getImage();

                if(image1!=null)
                {
                    InputImage image2=InputImage.fromMediaImage(image1,image.getImageInfo().getRotationDegrees());

                    BarcodeScanner scanner= BarcodeScanning.getClient();

                    Task<List<Barcode>> results=scanner.process(image2);
                    results.addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
                        @Override
                        public void onSuccess(List<Barcode> barcodes) {
                            for(Barcode barcode:barcodes){
                                final  String getValue =barcode.getRawValue();

                                qrtxt.setText(getValue);
                            }
                            image.close();
                            image1.close();
                        }
                    });
                }

            }
        });

        Preview preview=new Preview.Builder().build();
        CameraSelector cameraSelector=new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();
        preview.setSurfaceProvider(camview.getSurfaceProvider());
        processCameraProvider.bindToLifecycle(this,cameraSelector,imageAnalysis,preview);*/



    }

}