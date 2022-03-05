package com.revature.controllers;

import com.revature.models.Invoice;
import com.revature.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@CrossOrigin
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices/seller/{id}")
    public List<Invoice> getAllInvoicesBySellerId(@PathVariable("id")String id) {
      return invoiceService.getAllInvoicesBySellerId(Integer.parseInt(id));

    }
}
