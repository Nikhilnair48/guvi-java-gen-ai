package com.guvi.subscriptionmanager.repo;

import java.util.List;

import com.guvi.subscriptionmanager.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    List<Invoice> findByUserId(Long userId);

    List<Invoice> findBySubscriptionId(Long subscriptionId);
}