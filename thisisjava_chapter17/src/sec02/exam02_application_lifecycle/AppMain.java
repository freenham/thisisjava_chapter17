package sec02.exam02_application_lifecycle;

import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application{
	String ip;
	String port;
	
	public AppMain(){
		System.out.println(Thread.currentThread().getName()+": AppMain() 호출");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName()+": init() 호출");
		Parameters params = this.getParameters();
		Map<String, String> map = params.getNamed();
		ip = map.get("ip");
		port = map.get("port");
		System.out.println("ip: "+ip);
		System.out.println("port: "+port);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+": start() 호출");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName()+": stop() 호출");;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
