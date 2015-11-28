package it.jaschke.alexandria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

//EDIT 3: basic version of scanner through ZXingScannerView

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    private final String LOG_TAG = ScannerActivity.class.getSimpleName();
    public final static String ISBN_EXTRA = "it.jaschke.alexandria.scan.result";
    public static final int SCAN_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String isbnStr = result.toString();

        /*Log.e(LOG_TAG, result.getText());
        Log.e(LOG_TAG, result.getBarcodeFormat().toString());*/


        if(isbnStr != null && !isbnStr.equals("")){
            Intent resultIsbnIntent = new Intent();
            resultIsbnIntent.putExtra(ISBN_EXTRA,isbnStr);
            setResult(RESULT_OK, resultIsbnIntent);
            finish();

        }

    }
}
