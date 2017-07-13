package sec09.exam02_blocking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		System.out.println("[작업 처리 요청]");
		Runnable runnalbe = new Runnable() {
			public void run() {
				int sum=0;
				for(int i=1;i<=10;i++) {
					sum += i;
				}
				System.out.println("[처리 결과]"+sum);
			}
		};
		
		Future future = executorService.submit(runnalbe);
		try {
			future.get();
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
