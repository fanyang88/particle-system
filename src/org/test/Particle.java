package org.test;

public class Particle {
	
	int color;
	int r;
	double vertical;
	double horizontal;
	int startx;
	int starty;
	int x,y;
	double starttime;
	
	public Particle(int color,int r,double vertical,double horizontal,int x, int y,double startime)
	{
		this.color=color;
		this.r=r;
		this.vertical=vertical;
		this.horizontal=horizontal;
		this.startx=x;
		this.x=x;
		this.starty=y;
		this.y=y;
		this.starttime=startime;
	}

}
