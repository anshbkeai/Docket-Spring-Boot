package com.test.macos;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class ApiService {
    public  Test  init(String serviceName) {
        Test paymentProcessor = new Test();
        paymentProcessor.setSource("Payment DB");
        paymentProcessor.setType("Database");
        paymentProcessor.setLast_sync(LocalDateTime.now().minusMinutes(1));
        paymentProcessor.setStatus("warning");
        paymentProcessor.setFailures((int)(Math.random()*10));
        paymentProcessor.setLogs(List.of(
                "1200 transactions processed",
                "3 failed due to invalid card tokens"
        ));

        Test emailQueue = new Test();
        emailQueue.setSource("RabbitMQ");
        emailQueue.setType("Queue");
        emailQueue.setLast_sync(LocalDateTime.now().minusSeconds(30));
        emailQueue.setStatus("healthy");
        emailQueue.setFailures(0);
        emailQueue.setLogs(List.of(
                "Email queue processed successfully",
                "Queue depth: 12"
        ));

        Test authService = new Test();
        authService.setSource("Auth Microservice");
        authService.setType("REST API");
        authService.setLast_sync(LocalDateTime.now().minusMinutes(2));
        authService.setStatus("critical");
        authService.setFailures(10);
        authService.setLogs(List.of(
                "Token validation failed for 10 users",
                "API timeout on /validateToken"
        ));

        Test userSyncJob = new Test();
        userSyncJob.setSource("User DB Sync Job");
        userSyncJob.setType("Batch Job");
        userSyncJob.setLast_sync(LocalDateTime.now().minusMinutes(5));
        userSyncJob.setStatus("warning");
        userSyncJob.setFailures(2);
        userSyncJob.setLogs(List.of(
                "500 records fetched",
                "2 skipped due to schema issues"
        ));

        Test inventoryCache = new Test();
        inventoryCache.setSource("Redis Cache");
        inventoryCache.setType("Cache");
        inventoryCache.setLast_sync(LocalDateTime.now().minusSeconds(45));
        inventoryCache.setStatus("healthy");
        inventoryCache.setFailures(0);
        inventoryCache.setLogs(List.of(
                "Cache hit rate: 96%",
                "Synced with Inventory DB successfully"
        ));

        Test shippingAPI = new Test();
        shippingAPI.setSource("3rd-Party Shipping API");
        shippingAPI.setType("External API");
        shippingAPI.setLast_sync(LocalDateTime.now().minusMinutes(7));
        shippingAPI.setStatus("critical");
        shippingAPI.setFailures(5);
        shippingAPI.setLogs(List.of(
                "GET /track failed 5 times",
                "API rate limit exceeded"
        ));

        System.out.println("🌐 Production System Health Snapshot - " + LocalDateTime.now());
        return switch (serviceName.toLowerCase()) {
            case "payment" -> paymentProcessor;
            case "email" ->emailQueue;
            case "auth" -> authService;
            case "user-sync" -> userSyncJob;
            case "inventory" -> inventoryCache;
            default -> throw new RuntimeException(HttpStatus.NOT_FOUND+ "Service not found");
        };

    }
}
