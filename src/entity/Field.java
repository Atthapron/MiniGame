package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import render.IRenderable;
import render.Resource;

public class Field implements IRenderable{
	//direction 1 is up
		//direction 2 is down
		//direction 3 is left
		//direction 4 is Right
		
		private static int[][] field = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,3,1,1,1,1,1},
				{0,0,0,0,2,0,0,0,0,0},
				{0,0,0,0,2,0,0,0,0,0},
				{1,1,1,1,6,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0}
			};
			//�͡Ẻ map

			public int getTerrain(int x,int y){
				if(x < 0 || x >= field[0].length || y < 0 || y >= field.length)
					return -3;
				return field[y][x];
			}
			
			/*private int getTileIndex(int x,int y){
				int terrain = getTerrain(x, y);
				if(terrain <= 0 && terrain >= -2)
					return -terrain;
				else
					return 0;
			}*/
			
			@Override
			public int getZ() {
				return 2000;
			}

			@Override
			public void draw(Graphics2D g2d) {
				
				for(int x=0; x<= field[0].length; x++){
					for(int y=0; y<= field.length; y++){
						if(getTerrain(x,y) == 0) // 
							g2d.drawImage(Resource.tile.getSubimage(getTerrain(x, y)*64, 0, 64, 64), null, x*64, y*64);//
						
					}
				}
				
			}

			@Override
			public boolean isDestroyed() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isVisible() {
				// TODO Auto-generated method stub
				return true;
			}
		
}
