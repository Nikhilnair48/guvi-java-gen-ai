package com.guvi.repo;

import java.util.List;
import java.util.Optional;

import com.guvi.model.Invoice;
import com.guvi.model.InvoiceStatus;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);

    Optional<Invoice> findById(String id);

    List<Invoice> findBySubscriptionId(String subscriptionId);

    List<Invoice> findBySubscriptionIdAndStatus(String subscriptionId, InvoiceStatus status);
}
