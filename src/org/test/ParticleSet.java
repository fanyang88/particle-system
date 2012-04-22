package org.test;

import java.util.ArrayList;

import android.graphics.Color;

public class ParticleSet {
	
	ArrayList <Particle> pset;
	
	public ParticleSet()
	{
		pset=new ArrayList<Particle> ();
		
	}
	
	public int getColor(int i)
	{
	   int color=Color.RED;
	   switch(i%4)
	   {
	   case 0:
		   color=Color.RED;
		   break;
	   case 1:
		   color=Color.YELLOW;
		   break;
	   case 2:
		   color=Color.BLUE;
		   break;
	   case 3:
		   color=Color.GREEN;
		   break;  
	   }
	   return color;
	}
	
	public void add(int count, double starttime)
	{
		for(int i=0;i<count;i++)
		{
			int tcolor=this.getColor(i);
			int tr=1;
			double tv=-30+10*(Math.random());
			
			double th=10-20*(Math.random());
			int tx=160;
			int ty=(int)(100-10*(Math.random()));
			Particle particle=new Particle(tcolor,tr,tv,th,tx,ty,starttime);
			pset.add(particle);
		}
	}

}
