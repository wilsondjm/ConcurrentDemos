package me.vincent.concurrent.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class FluxSimpleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useFlux();
	}
	
	public static void useFlux() {
		Flux.just(0,1,2,3,4,5,6,7)
		.filter(i -> i%2 ==0)
		.subscribeOn(Schedulers.elastic())//ReactorThreadFactory newElasticScheduler 弹性申请的线程pool值一个最小值1，最大是Integer.MAX_VALUE
//		.subscribeOn(Schedulers.parallel())// 并行直接申请核心数的线程pool，可能性能更差
		.subscribe(FluxSimpleDemo::printMsg);
	}
	
	public static void printMsg(Object payLoad) {
		System.out.printf("Thread %s : %s\n", Thread.currentThread().getName(), payLoad);
	}

}
