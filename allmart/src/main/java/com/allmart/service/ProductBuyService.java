package com.allmart.service;

import com.allmart.dto.CartDetailsDto;
import com.allmart.dto.CheckOutSummaryDto;

public interface ProductBuyService {

	CheckOutSummaryDto checkOut(CartDetailsDto cartDetailsDto);

}
