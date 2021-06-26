package com.syedsamiuddin.Timestamp.service;

import com.syedsamiuddin.Timestamp.entity.Timestamp;
import com.syedsamiuddin.Timestamp.error.TimestampInvalid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimestampServiceImpl implements  TimestampService{


    private final Logger LOGGER = LoggerFactory.getLogger(TimestampServiceImpl.class);

    @Override
    public Timestamp getConvertTimes(String time) throws ParseException,TimestampInvalid {
        String pattern = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
        String epochPattern = "\\d+";

        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        Timestamp timestamp;

        //it is a date
        if(time.matches(pattern)){
            LOGGER.info("Inside TimestampServiceImpl, Date block");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time);

            Long epochTime = date.getTime()/1000L;
            String strDate = formatter.format(date);

            timestamp = new Timestamp(epochTime, strDate);

        } else if(time.matches(epochPattern)) {
            //epoch time
            LOGGER.info("Inside TimestampServiceImpl, Epoch block");

            Long longTime = Long.parseLong(time);

            Date date = new Date();
            date.setTime(longTime*1000L);


            String strDate = formatter.format(date);

            timestamp = new Timestamp(longTime, strDate);
        } else {
            LOGGER.info("Inside TimestampServiceImpl, Exception block");

            throw new TimestampInvalid("Enter valid epoch time or date in (yyyy-MM-dd) format!");
        }

        LOGGER.info("Inside TimestampServiceImpl, getConvertTimes");

        return timestamp;
    }
}
