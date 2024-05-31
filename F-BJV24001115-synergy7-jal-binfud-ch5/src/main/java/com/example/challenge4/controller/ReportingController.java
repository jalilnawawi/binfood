package com.example.challenge4.controller;

import com.example.challenge4.dto.merchant.MerchantReportDto;
import com.example.challenge4.dto.orderDetail.OrderDetailMerchantReportDto;
import com.example.challenge4.dto.orderDetail.OrderDetailReportDto;
import com.example.challenge4.dto.orderDetail.OrderDetailRequestMerchantReportDto;
import com.example.challenge4.service.InvoiceServiceFacade;
import com.example.challenge4.service.JasperService;

import com.example.challenge4.service.MerchantService;
import com.example.challenge4.service.OrderDetailService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("report")
public class ReportingController {
    @Autowired
    InvoiceServiceFacade invoiceServiceFacade;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    JasperService jasperService;

    @GetMapping("/generate/{format}/{userId}")
    public ResponseEntity<Resource> getAll(@PathVariable String format,@PathVariable UUID userId) throws JRException {
        OrderDetailReportDto orderDetailReportDto = invoiceServiceFacade.reportInvoice(userId);
        byte[] reportContent = jasperService.getOrderReport(orderDetailReportDto, format);

        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("order-report."+format).build().toString())
                .body(resource);
    }

    @GetMapping("/generate/{merchantId}")
    public OrderDetailMerchantReportDto getMerchantReport(@PathVariable UUID merchantId, @RequestBody OrderDetailRequestMerchantReportDto orderDetailRequestMerchantReportDto){
        return orderDetailService.getMerchantReport(orderDetailRequestMerchantReportDto);
    }

}
