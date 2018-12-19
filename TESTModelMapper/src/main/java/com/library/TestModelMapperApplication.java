package com.library;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import pl.javastart.beans.NamesRepository;


@SpringBootApplication
public class TestModelMapperApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TestModelMapperApplication.class, args);
		ModelMapper modelMapper = new ModelMapper();
		Order order = ctx.getBean(Order.class);
		OrderDto orderDTO = modelMapper.map(order, OrderDto.class);

		ctx.close();
	}

}
