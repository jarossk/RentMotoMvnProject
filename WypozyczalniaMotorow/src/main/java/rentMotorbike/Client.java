package rentMotorbike;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.log4j.*;


@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int id;
	
	private static Logger myLogger = Logger.getLogger(Client.class);
	
	String name;
	String surename;
	
	List<Motor> MotorList;
	
	public Client (String name, String surename, List<Motor> MotorList) {
		this.name = name;
		this.surename = surename;
		this.MotorList = MotorList;
		
	}

	public void borrowMotor (Motor k) {
		MotorList.add(k);
		myLogger.info("Wypozyczony motocykl " + k.maker + ", model " + k.name);
	}
	
	public void returnMotor(Motor k) {
		MotorList.remove(k);
		myLogger.info("Zwrocony motocykl " + k.maker + ", model " + k.name);
	}
	
	public Motor hasMotor(Motor k){
		for (Motor q : MotorList) {
			if (k.equals(q)) {
				return q;
			}
		}
		return null;
	}
	
	public void printMotorList() {
		for (Motor k : MotorList)
			k.printMotor();
	}
	
	public List<Motor> findALLMotorsByName(String name) {
		List<Motor> results = new ArrayList<Motor>();
		for (Motor k : MotorList) {
			if (k.getName().equals(name)) {
				results.add(k);
			}
		}
		return results;
	}
	
	public List<Motor> findALLMotorsByMaker(String maker) {
		List<Motor> results = new ArrayList<Motor>();
		for (Motor k : MotorList) {
			if (k.getMaker().equals(maker)) {
				results.add(k);
			}
		}
		return results;
	}
	
	public void removeAllMotorsByList(List<Motor> tmpMotorList) {
		for (Motor k : MotorList) {
			for (Motor tmpK : tmpMotorList) {
				if (k.equals(tmpK)) {
					MotorList.remove(k);
			    }
			}
		}
	}
	
	public void renameAllMotorsByName(List<Motor> motorList, String newName) {
		for (Motor k : motorList) {
			k.setName(newName);
		}
	}
	
	public void renameAllMotorsByMaker(List<Motor> motorList, String newMaker) {
		for (Motor k : motorList) {
			k.setName(newMaker);
		}
	}
	
	public void printClient() {
		System.out.println();
		System.out.println("\tKlient");
		System.out.println("\tDane osobowe: " + this.name + ", " + this.surename);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surename;
	}

	public void setSurname(String surname) {
		this.surename = surname;
	}
	
	public List<Motor> getMotorList() {
		return MotorList;
	}
	
	public void setMotorList(List<Motor> motorList) {
		MotorList = motorList;
	}
	
}
