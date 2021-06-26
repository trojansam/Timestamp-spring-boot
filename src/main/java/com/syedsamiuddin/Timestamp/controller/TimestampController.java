package com.syedsamiuddin.Timestamp.controller;

import com.syedsamiuddin.Timestamp.error.TimestampInvalid;
import com.syedsamiuddin.Timestamp.service.TimestampService;
import com.syedsamiuddin.Timestamp.entity.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class TimestampController {


    private final Logger LOGGER = LoggerFactory.getLogger(TimestampController.class);

    @Autowired
    private TimestampService timestampService;



    @GetMapping("/api/{time}")
    public Timestamp getConvertTimes(@PathVariable("time") String time) throws ParseException, TimestampInvalid {

        LOGGER.info("INSIDE TimestampController, getConvertTimes(), Time = "+time);
        return timestampService.getConvertTimes(time);

    }
}
