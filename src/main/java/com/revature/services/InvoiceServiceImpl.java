package com.revature.services;

import com.revature.models.Invoice;
import com.revature.repositories.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    InvoiceRepo invoiceRepo;

    /**
     * Gets all invoices through seller id
     * @return a list of all customer invoices
     */
    @Override
    public List<Invoice> getAllInvoicesBySellerId(int id){
        List<Invoice> invoices = (List<Invoice>) invoiceRepo.findAll();
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getId() == id)
                .collect(Collectors.toList());

    }
}
