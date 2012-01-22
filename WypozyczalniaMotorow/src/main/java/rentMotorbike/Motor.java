package rentMotorbike;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Motor implements ToMotor {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String name;
	public String engineVolume;
	public String maker;
	
	public Motor(String name, String engineVolume, String maker) {
		this.name = name;
		this.engineVolume = engineVolume;
		this.maker = maker;
	}
	
	public Motor(MotorName name, EngineVolume engineVolume, Maker maker){
		this.name = name.toString();
		this.engineVolume  = engineVolume.toString();
		this.maker = maker.toString();
	}
	
	public void printMotor() {
		System.out.println("\t\tNazwa motocykla: " + this.name);
		System.out.println("\t\tProducent: " + this.maker + 
				", Pojemność silnika: " + this.engineVolume);
		System.out.println();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private double power;
	
	public double getPower(){
		return power;
	}
	
	public void setPower(double power) throws MyException
	{
		if (power < 0)
			throw new MyException("power can not be less than zero");
		else
			this.power = power;
	}
	
	public String getEngineVolume() {
		return engineVolume;
	}
	
	public void setEngineVolume(String engineVolume) {
		this.engineVolume = engineVolume;
	}
		
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
}