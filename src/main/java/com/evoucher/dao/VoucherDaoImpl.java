package com.evoucher.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.evoucher.model.Evoucher;

@Component
public class VoucherDaoImpl implements VoucherDao {
	 JdbcTemplate jdbcTemplate;
	
	@Autowired
	public VoucherDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_SAVE_VOUCHER = "insert into people(id, voucher, status) values(?,?,?,?)";

	@Override
	public List<Evoucher> saveAll(List<Evoucher> e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Evoucher e) {
		return jdbcTemplate.update(SQL_SAVE_VOUCHER, e.getId(), e.getVoucher(), e.getStatus());
	}

}
