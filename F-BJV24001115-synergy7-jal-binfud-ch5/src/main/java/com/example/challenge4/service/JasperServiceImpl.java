package com.example.challenge4.service;

import com.example.challenge4.dto.orderDetail.OrderDetailReportDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperServiceImpl implements JasperService {
    @Override
    public byte[] getOrderReport(OrderDetailReportDto orderDetailReportDto, String format) {
        JasperReport jasperReport;
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(ResourceUtils.getFile("order-report.jasper"));
        } catch (FileNotFoundException | JRException e) {
            try {
             File file = ResourceUtils.getFile("classpath:jasper/order-report.jrxml");
                jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
                JRSaver.saveObject(jasperReport, "order-report.jasper");
            } catch (FileNotFoundException | JRException ex) {
                throw new RuntimeException(ex);
            }
        }

        Object[] OrderDetailReportDto = {orderDetailReportDto};
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(OrderDetailReportDto);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", orderDetailReportDto.getUsername());
        parameters.put("productName", orderDetailReportDto.getProductName());
        parameters.put("price", orderDetailReportDto.getPrice());
        parameters.put("quantity", orderDetailReportDto.getQuantity());
        parameters.put("totalPrice", orderDetailReportDto.getTotalPrice());
        parameters.put("orderId" , orderDetailReportDto.getOrderId());
        parameters.put("merchantName", orderDetailReportDto.getMerchantName());

        JasperPrint jasperPrint;
        byte[] reportContent;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            switch (format){
                case "pdf" -> reportContent = JasperExportManager.exportReportToPdf(jasperPrint);
                default -> throw new RuntimeException();
            }
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

        return reportContent;
    }
}
