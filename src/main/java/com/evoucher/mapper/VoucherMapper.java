package com.evoucher.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evoucher.model.Evoucher;

public class VoucherMapper implements RowMapper<Evoucher> {
	
	public Evoucher mapRow(ResultSet resultSet, int i) throws SQLException {

		Evoucher voucher = new Evoucher();
		voucher.setId(resultSet.getInt("id"));
		voucher.setVoucher(resultSet.getString("voucher"));
		voucher.setStatus(resultSet.getString("status"));
		return voucher;
	}

}
