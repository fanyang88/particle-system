package org.test;

import java.util.ArrayList;

public class ParticleThread extends Thread{
	
	boolean flag;
	ParticleView father;
	int sleepSpan=80;
	double time=0;
	double span=0.15;
	
	public ParticleThread(ParticleView father)
	{
		this.father=father;
		this.flag=true;
	}
	
	public void run()
	{
		while(flag)
		{
			father.ps.add(5,time);
			ArrayList <Particle> tempset=father.ps.pset;
			int count =tempset.size();
			
			for(int i=0;i<count;i++)
			{
				Particle particle=tempset.get(i);
				double timespan=time-particle.starttime;
				int tempx=(int)(particle.startx+particle.horizontal*timespan);
				int tempy=(int)(particle.starty+4.9*timespan*timespan+particle.vertical*timespan);
				if(tempy>300)
				{
					tempset.remove(particle);
					count =tempset.size();
				}
				particle.x=tempx;
				particle.y=tempy;
			}
			time+=span;
			try{
				Thread.sleep(sleepSpan);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
