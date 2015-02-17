package com.paro.springBatch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report>{
    
    @Override
    public Report process(Report item) throws Exception{
        System.out.println("processing ....");
        return item;
    }
}