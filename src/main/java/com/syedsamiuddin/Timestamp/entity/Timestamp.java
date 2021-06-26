package com.syedsamiuddin.Timestamp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timestamp {
    private Long unix;
    private String utc;
}
