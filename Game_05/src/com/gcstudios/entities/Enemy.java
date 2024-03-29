package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.AStar;
import com.gcstudios.world.Vector2i;
import com.gcstudios.world.World;

public class Enemy extends Entity{
	

	
	public boolean right = true,left = false;
	
	public int vida = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick() {
		
		path = AStar.findPath(Game.world, new Vector2i(this.getX() / 16, this.getY() / 16), new Vector2i(World.xFinal, World.yFinal));
		followPath(path);
		
		if(x >= Game.WIDTH) {
			Game.vida -= Entity.rand.nextDouble();
			Game.entities.remove(this);
			return;
		}
	}

}
