package com.avbook.app.api.controller;

import com.avbook.app.api.dto.OrderRequest;
import com.avbook.app.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping("/warehouse")
    public void deliverFromWarehouseWithPartsUsed(@RequestBody OrderRequest request) {
        deliveryService.deliverFromWarehouseWithPartsUsed(request);
    }
    @DeleteMapping("/warehouse/{id}")
        public void deleteFromWarehouseById(@PathVariable UUID id) {
            deliveryService.deleteFromWarehouse(id);
        }
}
