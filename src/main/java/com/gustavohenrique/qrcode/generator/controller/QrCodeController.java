package com.gustavohenrique.qrcode.generator.controller;

import com.gustavohenrique.qrcode.generator.dto.QrCodeGenerateRequest;
import com.gustavohenrique.qrcode.generator.dto.QrCodeGenerateResponse;

import com.gustavohenrique.qrcode.generator.service.QrCodeGenerationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrCode")
public class QrCodeController {

    private final QrCodeGenerationService qrCodeGenerationService;

    public QrCodeController(QrCodeGenerationService qrCodeGenerationService) {
        this.qrCodeGenerationService = qrCodeGenerationService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest resquest) {
        try {
            QrCodeGenerateResponse response = this.qrCodeGenerationService.generateUploadQrCode(resquest.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
