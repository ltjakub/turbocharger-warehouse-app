package com.avbook.app.service;

import com.avbook.app.api.dto.OrderRequest;
import com.avbook.app.api.dto.PartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final CompanyService companyService;
    private final PartService partService;
    private final TurbochargerService turbochargerService;

    public void deliverFromWarehouseWithPartsUsed(OrderRequest request) {
        request.getParts().forEach(part -> partService.decrementQuantity(part.getId(), part.getQuantity()));
        turbochargerService.deleteById(request.getTurbochargerId());
    }
    public void deleteFromWarehouse(UUID id) {
        turbochargerService.deleteById(id);
    }

}
