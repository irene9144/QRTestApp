package com.example.qrtest.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qrtest.databinding.ActiviyScanQrBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class ScanQRActivity : AppCompatActivity() {
    private lateinit var binding: ActiviyScanQrBinding

    private lateinit var txtResult : TextView

    // 스캐너 설정
    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        // result : 스캔된 결과

        // 내용이 없다면
        if (result.contents == null) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
        else { // 내용이 있다면

            // 1. Toast 메시지 출력.
            Toast.makeText(
                this,
                "Scanned: " + result.contents,
                Toast.LENGTH_LONG
            ).show()

            // 2. 결과 값 TextView에 출력.
            txtResult.text = result.contents.toString()
        }
    }

    fun onScanButtonClicked() {
        // Launch ( SCAN 실행 )
        barcodeLauncher.launch(ScanOptions())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiviyScanQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtResult = binding.txtResult

        // SCAN 버튼 클릭
        binding.btnScan.setOnClickListener {
            onScanButtonClicked()
        }
    }
}