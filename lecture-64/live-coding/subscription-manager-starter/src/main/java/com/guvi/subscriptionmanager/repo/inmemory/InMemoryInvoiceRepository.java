package com.guvi.subscriptionmanager.repo.inmemory;

import com.guvi.subscriptionmanager.model.Invoice;
import com.guvi.subscriptionmanager.repo.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryInvoiceRepository implements InvoiceRepository {

    // ConcurrentHashMap is safe when multiple HTTP requests hit the app at the same time.
    private final ConcurrentHashMap<Long, Invoice> invoicesById = new ConcurrentHashMap<>();
    private final AtomicLong idSeq = new AtomicLong(1);

    @Override
    public Invoice save(Invoice invoice) {
        if (invoice.getId() == null) {
            invoice.setId(idSeq.getAndIncrement());
        }
        invoicesById.put(invoice.getId(), invoice);
        return invoice;
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(invoicesById.get(id));
    }

    @Override
    public List<Invoice> findByUserId(Long userId) {
        List<Invoice> out = new ArrayList<>();
        if (userId == null) {
            return out;
        }

        for (Invoice i : invoicesById.values()) {
            if (userId.equals(i.getUserId())) {
                out.add(i);
            }
        }
        return out;
    }

    @Override
    public List<Invoice> findBySubscriptionId(Long subscriptionId) {
        List<Invoice> out = new ArrayList<>();
        if (subscriptionId == null) {
            return out;
        }

        for (Invoice i : invoicesById.values()) {
            if (subscriptionId.equals(i.getSubscriptionId())) {
                out.add(i);
            }
        }
        return out;
    }
}
