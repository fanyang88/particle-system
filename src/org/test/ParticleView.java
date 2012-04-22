package org.test;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ParticleView extends SurfaceView implements SurfaceHolder.Callback{

	ParticleSet ps;
	public static final int OUTLINE=300;
	DrawThread dt;
	ParticleThread pt;
	String fps="FPS:N/A";
	
	public ParticleView(Context context)
	{
		super(context);
		this.getHolder().addCallback(this);
		dt=new DrawThread(this, getHolder());
		ps=new ParticleSet();
		pt=new ParticleThread(this);
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	public void surfaceCreated(SurfaceHolder holder)
	{
		if(!dt.isAlive())
			dt.start();
		if(!pt.isAlive())
			pt.start();
	}
	
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		dt.flag = false;	//stop thread
		dt = null;	
		pt.flag = false;	//stop thread
		pt = null;	
	}
	
	public void doDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		ArrayList <Particle> particleset=ps.pset;
		Paint paint=new Paint();
		
		for(int i=0;i<particleset.size();i++)
		{
			Particle p=particleset.get(i);
			paint.setColor(p.color);
			int tempx=p.x;
			int tempy=p.y;
			int radius=p.r;
			RectF oval=new RectF(tempx,tempy,tempx+2*radius,tempy+2*radius);
			canvas.drawOval(oval, paint);
		}
		paint.setColor(Color.WHITE);
		paint.setTextSize(18);
		paint.setAntiAlias(true);
		canvas.drawText(fps, 15, 15, paint);
		
	}
	
	
	
}
