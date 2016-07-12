package Drone;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
LinkedList<GameObject> object = new LinkedList<GameObject>();
public void tick(){
	for(int i=0;i<object.size();i++){
		GameObject  tempObject = object.get(i);
		tempObject.tick();
		
	}
}

public void render(Graphics gs){
for(int i=0;i<object.size();i++){
	GameObject  tempObject = object.get(i);
	tempObject.render(gs);
 }
}
public void addObject(GameObject object ){
	this.object.add(object);
}
public void removeObject(GameObject object){
	this.object.remove(object);
}
}
