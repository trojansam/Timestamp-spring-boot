package com.syedsamiuddin.Timestamp.service;


import com.syedsamiuddin.Timestamp.entity.Timestamp;
import com.syedsamiuddin.Timestamp.error.TimestampInvalid;

import java.text.ParseException;

public interface TimestampService {
    public Timestamp getConvertTimes(String time) throws ParseException, TimestampInvalid;
}