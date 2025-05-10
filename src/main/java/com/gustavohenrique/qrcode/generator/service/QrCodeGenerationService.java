package com.gustavohenrique.qrcode.generator.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.gustavohenrique.qrcode.generator.dto.QrCodeGenerateResponse;
import com.gustavohenrique.qrcode.generator.ports.StoragePorts;

@Service
public class QrCodeGenerationService {

    private final StoragePorts storagePorts;

    public QrCodeGenerationService(StoragePorts storagePorts) {
        this.storagePorts = storagePorts;
    }

    public QrCodeGenerateResponse generateUploadQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        String url = storagePorts.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image/png");

        return new QrCodeGenerateResponse(url);
    }
}
