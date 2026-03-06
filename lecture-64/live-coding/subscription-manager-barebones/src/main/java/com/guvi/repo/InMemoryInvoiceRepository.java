package com.guvi.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.guvi.model.Invoice;
import com.guvi.model.InvoiceStatus;

/**
 * Thread-safe in-memory repository.
 */
public class InMemoryInvoiceRepository implements InvoiceRepository {

    private final ConcurrentHashMap<String, Invoice> store = new ConcurrentHashMap<>();

    @Override
    public Invoice save(Invoice invoice) {
        store.put(invoice.getId(), invoice);
        return invoice;
    }

    @Override
    public Optional<Invoice> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Invoice> findBySubscriptionId(String subscriptionId) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice i : store.values()) {
            if (i.getSubscriptionId() != null && i.getSubscriptionId().equals(subscriptionId)) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<Invoice> findBySubscriptionIdAndStatus(String subscriptionId, InvoiceStatus status) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice i : store.values()) {
            if (i.getSubscriptionId() != null && i.getSubscriptionId().equals(subscriptionId) && i.getStatus() == status) {
                result.add(i);
            }
        }
        return result;
    }
}
