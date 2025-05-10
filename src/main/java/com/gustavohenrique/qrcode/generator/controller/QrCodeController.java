package com.gustavohenrique.qrcode.generator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavohenrique.qrcode.generator.dto.QrCodeGenerateRequest;
import com.gustavohenrique.qrcode.generator.dto.QrCodeGenerateResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/qrCode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest resquest) {

        return null;
    }

}
