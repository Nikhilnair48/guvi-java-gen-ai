package com.guvi.subscriptionmanager.repo;

import com.guvi.subscriptionmanager.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Long id);

    List<Invoice> findByUserId(Long userId);

    List<Invoice> findBySubscriptionId(Long subscriptionId);
}
