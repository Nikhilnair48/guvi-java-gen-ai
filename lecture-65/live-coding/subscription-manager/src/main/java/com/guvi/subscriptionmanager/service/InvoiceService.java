package com.guvi.subscriptionmanager.service;

import com.guvi.subscriptionmanager.exception.BusinessConflictException;
import com.guvi.subscriptionmanager.exception.ResourceNotFoundException;
import com.guvi.subscriptionmanager.model.Invoice;
import com.guvi.subscriptionmanager.model.InvoiceStatus;
import com.guvi.subscriptionmanager.repo.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> listByUser(Long userId) {
        return invoiceRepository.findByUserId(userId);
    }

    public Invoice pay(Long userId, Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found: " + invoiceId));

        if (!userId.equals(invoice.getUserId())) {
            throw new BusinessConflictException("You cannot pay someone else's invoice");
        }

        if (invoice.getStatus() != InvoiceStatus.DUE) {
            throw new BusinessConflictException("Only DUE invoices can be paid");
        }

        invoice.setStatus(InvoiceStatus.PAID);
        invoice.setPaidAt(LocalDateTime.now());

        return invoiceRepository.save(invoice);
    }
}
