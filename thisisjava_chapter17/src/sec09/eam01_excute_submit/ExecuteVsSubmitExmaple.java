package sec09.eam01_excute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExmaple {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("{총 쓰레드 개수:"+poolSize+"} 작업 처리" + threadName);
					int value = Integer.parseInt("삼");
				};
			};
//			executorService.execute(runnable);
			executorService.submit(runnable);
			Thread.sleep(10);

		}
		executorService.shutdown();
	}

}
