package org.onedatashare.transferservice.odstransferservice.service;


import org.onedatashare.transferservice.odstransferservice.controller.TransferController;
import org.onedatashare.transferservice.odstransferservice.model.request.TransferJobRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    Logger logger = LoggerFactory.getLogger(TransferService.class);

    public ResponseEntity<String> submit(TransferJobRequest request) {
        logger.info("Inside submit function");
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
