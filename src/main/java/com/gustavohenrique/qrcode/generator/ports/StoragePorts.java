package com.gustavohenrique.qrcode.generator.ports;

public interface StoragePorts {

    String uploadFile(byte[] fileContent, String fileName, String contentType);
}
