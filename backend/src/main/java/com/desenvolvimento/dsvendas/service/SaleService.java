package com.desenvolvimento.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvimento.dsvendas.dto.SaleDTO;
import com.desenvolvimento.dsvendas.dto.SaleSumDTO;
import com.desenvolvimento.dsvendas.dto.SalesSuccessDTO;
import com.desenvolvimento.dsvendas.entities.Sale;
import com.desenvolvimento.dsvendas.repositories.SaleRepository;
import com.desenvolvimento.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
