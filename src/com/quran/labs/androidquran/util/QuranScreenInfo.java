package com.quran.labs.androidquran.util;

import android.content.res.Configuration;

public class QuranScreenInfo {

	private static QuranScreenInfo instance = null;
	
	private int width;
	private int height;
	private int max_width;
	private int orientation;
	
	private QuranScreenInfo(int width, int height){
		this.orientation = Configuration.ORIENTATION_PORTRAIT;
		this.width = width;
		this.height = height;
		this.max_width = (width > height)? width : height;
	}
	
	public static QuranScreenInfo getInstance(){
		return instance;
	}
	
	public static void initialize(int width, int height){
		instance = new QuranScreenInfo(width, height);
	}
	
	public int getWidth(){ return this.width; }
	public int getHeight(){ return this.height; }
	
	public String getWidthParam(){
		if (this.max_width <= 480) return "_480";
		else if (this.max_width <= 800) return "_800";
		else return "_1024";
	}
	
	public String getWidthParamNoUnderScore(){
		if (this.max_width <= 480) return "480";
		else if (this.max_width <= 800) return "800";
		else return "1024";
	}
	
	public boolean isLandscapeOrientation() {
		return this.orientation == Configuration.ORIENTATION_LANDSCAPE;
	}
		
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public float getRatio() {
		if (height > width)
			return (float)(1.0*height/width);
		return (float)(1.0*width/height);
	}
}
