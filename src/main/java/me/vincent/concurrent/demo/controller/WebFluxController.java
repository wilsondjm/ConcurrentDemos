package me.vincent.concurrent.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {
	
	@RequestMapping("/test")
	public Mono<String> index(){ //Mono单数据， Java ：Optional，RxJava ： Single
		printMsg("执行计算");       //Flux 多数据集合， Java: Collection, RxJava: Observable
		
		return Mono.fromSupplier(() ->{
			printMsg("返回结果");
			return "Hello World";
		});
	}

	public static void printMsg(Object payLoad) {
		System.out.printf("Thread %s : %s\n", Thread.currentThread().getName(), payLoad);
	}
}
