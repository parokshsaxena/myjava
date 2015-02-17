package com.paro.springBatch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ReportFieldSetMapper implements FieldSetMapper<Report>{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    @Override
    public Report mapFieldSet(FieldSet fs) throws BindException {
        Report report = new Report();
        report.setId(fs.readInt(0));
        report.setSales(fs.readBigDecimal(1));
        report.setQty(fs.readInt(2));
        report.setStaffName(fs.readString(3));
        String date = fs.readString(4);
        try{
            report.setDate(dateFormat.parse(date));
        }catch(ParseException ex){
             ex.printStackTrace();
        }
        return report;
    }
    
}