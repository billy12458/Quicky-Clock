package Quicky_Clock;
public class GarbageCollect implements Runnable{
	@Override
	public void run(){
		try{while(true){
				Runtime.getRuntime().runFinalization();
				Thread.sleep(16000);
			}
		}catch(InterruptedException interruptedException1){
			interruptedException1.printStackTrace();
		}
	}
}
