package com.evoucher.dao;

import java.util.List;

import com.evoucher.model.Evoucher;

public interface VoucherDao {
	List<Evoucher> saveAll(List<Evoucher> e);
	int save(Evoucher e);
}
