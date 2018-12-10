package jdp2e.prototype.demo;

class Nano extends BasicCar 
{
	//A base price for Nano
	public int basePrice=100000;
    public Nano(String m)
    {
        modelName = m;
    }   
	@Override	
	public BasicCar clone() throws CloneNotSupportedException 
	{
		 return (Nano)super.clone();
		 //return this.clone();
	}
}