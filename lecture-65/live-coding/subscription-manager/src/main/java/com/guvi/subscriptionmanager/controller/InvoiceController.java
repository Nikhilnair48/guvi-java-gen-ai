package com.guvi.subscriptionmanager.controller;

import com.guvi.subscriptionmanager.model.Invoice;
import com.guvi.subscriptionmanager.service.CurrentUserProvider;
import com.guvi.subscriptionmanager.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final CurrentUserProvider currentUserProvider;

    public InvoiceController(InvoiceService invoiceService, CurrentUserProvider currentUserProvider) {
        this.invoiceService = invoiceService;
        this.currentUserProvider = currentUserProvider;
    }

    @GetMapping("/me")
    public List<Invoice> myInvoices() {
        Long userId = currentUserProvider.getCurrentUserId();
        return invoiceService.listByUser(userId);
    }

    @PostMapping("/{id}/pay")
    public Invoice pay(@PathVariable Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        return invoiceService.pay(userId, id);
    }
}
