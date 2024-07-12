package com.example.qrtest.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.qrtest.databinding.ActivityCreateQrBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class CreateQRActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateQrBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(
                "https://www.naver.com/",
                BarcodeFormat.QR_CODE,
                400,
                400
            )
            val imageViewQrCode: ImageView = binding
                .imageViewQrCode as ImageView
            imageViewQrCode.setImageBitmap(bitmap)
        } catch (e: Exception) {
        }

    }
}