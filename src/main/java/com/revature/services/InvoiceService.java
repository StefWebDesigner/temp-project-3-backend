package com.revature.services;

import com.revature.models.Invoice;

import java.util.List;



public interface InvoiceService {

    List<Invoice> getInvoiceByCustomerId(int id);



}
