package com.evoucher.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.evoucher.dao.VoucherDao;
import com.evoucher.model.Evoucher;
import com.evoucher.model.Status;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateEvoucherServiceImpl implements CreateEvoucherService{
	//public final CreateEvoucherRepository createEvoucherRepository;
	public final VoucherDao voucherDao;

	@Override
	public List<Evoucher> createEvoucher(Integer count) {
		List<Evoucher> evoucherList = new ArrayList<>();
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				Evoucher e = new Evoucher();
				e.setCreated(LocalDateTime.now());
				e.setModified(LocalDateTime.now());
				e.setStatus(String.valueOf(Status.VALID.ordinal()));
				e.setVoucher(RandomStringUtils.randomAlphanumeric(12).toUpperCase());
				evoucherList.add(e);
				voucherDao.save(e);
			}
		}
		return evoucherList;
	}

}
