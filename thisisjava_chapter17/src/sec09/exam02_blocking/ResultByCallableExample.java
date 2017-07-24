package sec09.exam02_blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		System.out.println("[작업 처리 요청]");
		Callable<Integer> task = new Callable<Integer>() {
			public Integer call() {
				int sum=0;
				for(int i=1;i<=10;i++) {
					sum += i;
				}
				return sum;
			}
			
		};
		
		Future<Integer> future = executorService.submit(task);
		try {
			int sum = future.get();
			System.out.println("[처리 결과]" + sum);
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
		
	}

}
