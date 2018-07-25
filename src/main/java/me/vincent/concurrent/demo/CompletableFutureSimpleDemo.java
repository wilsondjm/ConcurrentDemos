package me.vincent.concurrent.demo;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSimpleDemo {
    //结果很有意思，多次执行发现是不同的线程在输出结果
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMsg("Main");
		CompletableFuture.supplyAsync(()->{
			printMsg("1");
			return "To";
		}).thenApplyAsync(result -> {
			printMsg("2");
			return result + " End";
		}).thenAccept(CompletableFutureSimpleDemo::printMsg)
		.whenComplete((result, error) -> {
			printMsg("All end");
		})
		.join()
		;

	}
	
	public static void printMsg(String payLoad) {
		System.out.printf("Thread %s : %s\n", Thread.currentThread().getName(), payLoad);
	}

}
