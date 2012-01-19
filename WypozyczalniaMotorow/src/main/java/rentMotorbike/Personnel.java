package rentMotorbike;

import java.util.ArrayList;
import java.util.List;

import rentMotorbike.Client;

public class Personnel {

	String name;
	String surename;
	List<Client> ClientList = new ArrayList<Client>();
	
	public Personnel(String name, String surename, List<Client> ClientList) {
		this.name = name;
		this.surename = surename;
		this.ClientList = ClientList;
	}
	
	public void addClient(Client k){
		ClientList.add(k);
	}
	
	public void removeClient(Client k){
		ClientList.remove(k);
	}
	
	public Client isClient(Client c) {
		for (Client q : ClientList) {
			if(c.equals(q)){
				return q;
			}
		}
		return null;
	}
	
	public void printClientList()  {
		for(Client c : ClientList){
			c.printClient();
			c.printMotorList();
		}
	}
	
	public List<Client> findAllClientByName(String name) {
		List<Client> results = new ArrayList<Client>();
		for (Client c : ClientList) {
			if (c.getName().equals(name)) {
				results.add(c);
			}
		}
		return results;
	}
	
	public List<Client> findAllClientBySurename(String surename) {
		List<Client> results = new ArrayList<Client>();
		for (Client c : ClientList) {
			if (c.getSurname().equals(surename)) {
				results.add(c);
			}
		}
		return results;
	}
	
	public void renameAllClientByName(List<Client> clientList, String newName){
		for(Client c : clientList){
			c.setName(newName);
		}
	}
	
	public void renameAllClientBySurename(List<Client> clientList, String newSurename){
		for(Client c : clientList){
			c.setName(newSurename);
		}
	}
	
	public void removeAllClientsByList(List<Client> tmpClientList){
		for(Client c : ClientList){
			for(Client tmpC : tmpClientList){
				if(c.equals(tmpC)){
					ClientList.remove(c);
				}
			}
		}
	}
	
	public void printPersonnel() {
		System.out.println("Pracownik");
		System.out.println("Imie: " + this.name);
		System.out.println("Nazwisko: " + this.surename);
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurename() {
		return surename;
	}
	public void setSurname(String surename) {
		this.surename = surename;
	}
	
	public List<Client> getClientList() {
		return ClientList;
	}
	public void setClientList(List<Client> clientList) {
		ClientList = clientList;
	}
}
