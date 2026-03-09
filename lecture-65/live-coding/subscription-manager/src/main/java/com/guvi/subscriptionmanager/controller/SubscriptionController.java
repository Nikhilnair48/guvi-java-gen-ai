package com.guvi.subscriptionmanager.controller;

import com.guvi.subscriptionmanager.dto.SubscribeRequest;
import com.guvi.subscriptionmanager.model.Subscription;
import com.guvi.subscriptionmanager.service.CurrentUserProvider;
import com.guvi.subscriptionmanager.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final CurrentUserProvider currentUserProvider;

    public SubscriptionController(SubscriptionService subscriptionService, CurrentUserProvider currentUserProvider) {
        this.subscriptionService = subscriptionService;
        this.currentUserProvider = currentUserProvider;
    }

    @PostMapping
    public Subscription subscribe(@Valid @RequestBody SubscribeRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        return subscriptionService.subscribe(userId, request.getPlanCode(), request.isAutoRenew());
    }

    @GetMapping("/me")
    public List<Subscription> mySubscriptions() {
        Long userId = currentUserProvider.getCurrentUserId();
        return subscriptionService.listByUser(userId);
    }

    @PostMapping("/{id}/cancel")
    public Subscription cancel(@PathVariable Long id) {
        Long userId = currentUserProvider.getCurrentUserId();
        return subscriptionService.cancel(userId, id);
    }
}
