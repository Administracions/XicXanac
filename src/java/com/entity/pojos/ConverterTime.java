/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
@Converter(autoApply = true)
public class ConverterTime  implements AttributeConverter<Timestamp,LocalDateTime>{

    @Override
    public LocalDateTime convertToDatabaseColumn(Timestamp sqlTimestamp) {
  
 
         return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
        
        
    }

    @Override
    public Timestamp convertToEntityAttribute(LocalDateTime locDateTime) {
        
        
         return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
    
    }
    
}
