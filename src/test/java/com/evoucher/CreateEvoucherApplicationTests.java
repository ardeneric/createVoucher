package com.evoucher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.evoucher.model.Evoucher;
import com.evoucher.service.CreateEvoucherServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class CreateEvoucherApplicationTests {
	//@Mock
	//CreateEvoucherRepository createEvoucherRepository;
	
	CreateEvoucherServiceImpl createEvoucherService;
	List<Evoucher> evoucherList = new ArrayList<>();
	

	@Test
	public void contextLoads() {
		//given
		/*createEvoucherService = new CreateEvoucherServiceImpl(createEvoucherRepository);
		
		//when
		when(createEvoucherRepository.saveAll(evoucherList)).thenReturn(evoucherList);
		List<Evoucher> vList = createEvoucherService.createEvoucher(3);
		
		//then
		 assertThat(vList.size())
	      .isEqualTo(3);*/
	}

}
