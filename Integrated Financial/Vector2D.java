package test;
public class Vector2D
{

	private float x;
	private float y;
	
	public Vector2D()
	{
		this.setX(0);
		this.setY(0);
	}
	public Vector2D(float x, float y)
	{
		this.setX(x);
		this.setY(y);
	}
	public void set(float x, float y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	public void setX(float x)
	{
		this.x=x;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	//specialty method use during calculation of ball to ball collisions
	
	public float dot(Vector2D v2)
	{
		float result = 0.0f;
		result = this.getX()*v2.getX() + this.getY() * v2.getY();
		return result;
	}
	
	public float getLength()
	{
		return (float) Math.sqrt(getX() * getX() + getY() * getY());
	}
	
	public Vector2D add(Vector2D v2)
	{
		Vector2D result = new Vector2D();
		result.setX(getX() + v2.getX());
		result.setY(getY() + v2.getY());
		return result;
	}
	
	public Vector2D subtract(Vector2D v2)
	{
		Vector2D result = new Vector2D();
		result.setX(this.getX() - v2.getX());
		result.setY(this.getY() - v2.getY());
		
		return result;
	}
	
	public Vector2D multiply(float scaleFactor)
	{
		Vector2D result = new Vector2D();
		result.setX(this.getX() * scaleFactor);
		result.setY(this.getY() * scaleFactor);
		return result;
	}
	
	//Specialty method used during calculations of ball to ball collisions
	public Vector2D normalize()
	{
		float length = getLength();
		if(length != 0.0f)
		{
			this.setX(this.getX() / length);
			this.setY(this.getY() / length);
		}
		else
		{
			this.setX(0.0f);
			this.setY(0.0f);
		}
		return this;
	}
	public String toString()
	{
		return "("+x+", "+y+")";
	}
}