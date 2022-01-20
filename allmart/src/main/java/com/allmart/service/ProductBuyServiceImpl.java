package com.allmart.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmart.dto.CartDetailsDto;
import com.allmart.dto.CheckOutSummaryDto;
import com.allmart.dto.ProductDto;
import com.allmart.dto.TransactionDto;
import com.allmart.entity.Customer;
import com.allmart.entity.Orders;
import com.allmart.entity.Product;
import com.allmart.exception.BankSideException;
import com.allmart.exception.InvalidAccountNumber;
import com.allmart.exception.InvalidCustomerException;
import com.allmart.exception.InvalidProductInformation;
import com.allmart.repository.CustomerRepository;
import com.allmart.repository.OrdersRepository;
import com.allmart.repository.ProductRepository;
import com.allmart.external.BankServiceClient;

@Service
public class ProductBuyServiceImpl implements ProductBuyService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	private BankServiceClient bankServiceClient;
	private String transactionStatus;

	@Override
	public CheckOutSummaryDto checkOut(CartDetailsDto cartDetailsDto) {
		Customer customer;
		Orders order = new Orders();
		Optional<Customer> cust = customerRepository.findById(cartDetailsDto.getCustomerId().longValue());
		if (cust.isPresent()) {
			customer = cust.get();
		} else {
			throw new InvalidCustomerException();
		}

		Optional<Product> productOp = productRepository.findById(cartDetailsDto.getProductsId());

		if (productOp.isPresent()) {

			Product product = productOp.get();
			order.setProductId(product.getProductId());
			order.setQuantity(cartDetailsDto.getProductQty().intValue());
			order.setTotalAmt(cartDetailsDto.getProductQty().intValue() * product.getPrice());
			order.setAddressLine1(customer.getAddressLine1());
			order.setCity(customer.getAddressLine2());
			order.setOrderStatus("Success");
			order.setOrderRemarks("home address");
			order.setCustomerId(cartDetailsDto.getCustomerId().intValue());
			order.setAccountNumber(Long.parseLong(cartDetailsDto.getCustAccountNumber()));
			order.setCreatedDate(LocalDateTime.now());

			TransactionDto transactionDto = new TransactionDto();
			transactionDto.setFromAccount(Long.parseLong(cartDetailsDto.getCustAccountNumber()));
			transactionDto.setToAccount(500015L);
			transactionDto.setAmount(order.getTotalAmt());
			validateAcc(Integer.parseInt(cartDetailsDto.getCustAccountNumber()));
			try {
				transactionStatus = bankServiceClient.transafer(transactionDto);
				if (transactionStatus.equals("Transaction has been created")) {
					order = ordersRepository.save(order);
				} else {
					throw new RuntimeException();
				}
			} catch (Exception e) {
				throw new BankSideException();
			}
		} else {
			throw new InvalidProductInformation();
		}

		CheckOutSummaryDto checkOutSummaryDto = new CheckOutSummaryDto();
		checkOutSummaryDto.setOrderId(order.getOrderId());
		checkOutSummaryDto.setOrderStatus("success");
		checkOutSummaryDto.setOrderMessage("Order has been placed successfully");
		return checkOutSummaryDto;

	}

	public String validateAcc(Integer accNumber) throws InvalidAccountNumber {

		if (bankServiceClient.validateAcc(accNumber).equalsIgnoreCase("Valid")) {
			return "valid";

		} else
			throw new InvalidAccountNumber();
	}
}
