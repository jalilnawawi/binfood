package com.example.challenge4.service;

import com.example.challenge4.dto.merchant.*;
import com.example.challenge4.model.Merchant;
import java.util.List;
import java.util.UUID;

public interface MerchantService {
    List<Merchant> getAll();

    MerchantDto create(MerchantCreateRequestDto merchantCreateRequestDto);

    MerchantDto update(UUID id, MerchantUpdateStatus merchantUpdateStatus);
    MerchantDto delete(UUID id, MerchantDeleteRequestDto merchantDeleteRequestDto);

    MerchantDto getMerchantById(UUID merchantId);

    List<Merchant> getOpenMerchant();
}
