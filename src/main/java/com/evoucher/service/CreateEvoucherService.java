package com.evoucher.service;

import java.util.List;

import com.evoucher.model.Evoucher;

public interface CreateEvoucherService {
	public List<Evoucher> createEvoucher(Integer count);
}
