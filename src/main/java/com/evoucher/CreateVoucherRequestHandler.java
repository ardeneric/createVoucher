package com.evoucher;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.evoucher.model.Evoucher;
import com.evoucher.model.RequestClass;
import com.evoucher.service.CreateEvoucherService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateVoucherRequestHandler implements RequestHandler<RequestClass, List<Evoucher>>{
	public final CreateEvoucherService createEvoucherService;
	
	@Override
	public List<Evoucher> handleRequest(RequestClass input, Context context) {
		return createEvoucherService.createEvoucher(input.getCount());
	}

}
