package org.test;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class DrawThread extends Thread{

	ParticleView pv;				//BallView
	SurfaceHolder surfaceHolder;//SurfaceHolder
	boolean flag=false;			//thread running symbol
	int sleepSpan = 30;			//sleep time
	long start = System.nanoTime();	//record start time
	int count=0;		//record frame number
	//constructor
	public DrawThread(ParticleView pv,SurfaceHolder surfaceHolder){
		this.pv = pv;		
		this.surfaceHolder = surfaceHolder;	
		this.flag = true;		
	}
	//thread
	public void run(){
		Canvas canvas = null;
		while(flag){
			try{
				canvas = surfaceHolder.lockCanvas(null);
				synchronized(surfaceHolder){
					pv.doDraw(canvas);		
				}
			}
			catch(Exception e){
				e.printStackTrace();			
			}
			finally{
				if(canvas != null){		
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}		
			this.count++;
			if(count == 20){	//if frame number =20
				count = 0;		//clear counter
				long tempStamp = System.nanoTime();//get system time
				long span = tempStamp - start;		//get interval
				start = tempStamp;					//reset start
				double fps = Math.round(100000000000.0/span*20)/100.0;//calculate frame speed
				pv.fps = "FPS:"+fps;//fps=frame speed
			}
			try{
				Thread.sleep(sleepSpan);		
			}
			catch(Exception e){					
				e.printStackTrace();	
			}
		}
	}	
}