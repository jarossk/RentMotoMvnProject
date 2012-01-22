package rentMotorbike;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	private static Logger myLogger = Logger.getLogger(Main.class);

	public static void main(String[] args){
		
		PropertyConfigurator.configure("Log4j.properties");
				
		myLogger.info("Main info");
		myLogger.debug(args);
		myLogger.error(null);
		
		Motor GSX_R = new Motor(MotorName.GSX_R, EngineVolume.P_1000, Maker.SUZUKI);
		Motor MULTISTRADE = new Motor(MotorName.MULTISTRADE, EngineVolume.P_1200, Maker.DUCATI);
		Motor REPSOL = new Motor(MotorName.REPSOL, EngineVolume.P_1000RR, Maker.HONDA);
		Motor NINJA_ZX = new Motor(MotorName.NINJA_ZX, EngineVolume.P_600, Maker.KAWASAKI);
		Motor R6 = new Motor(MotorName.R6, EngineVolume.P_600, Maker.YAMAHA);
		Motor R1 = new Motor(MotorName.R1, EngineVolume.P_1000, Maker.YAMAHA);
		
		List<Motor> listMoto1 = new ArrayList<Motor>();
		listMoto1.add(GSX_R);
		listMoto1.add(REPSOL);
		listMoto1.add(NINJA_ZX);
		
		List<Motor> listMoto2 = new ArrayList<Motor>();
		listMoto2.add(R6);
		listMoto2.add(MULTISTRADE);
		
		Client Darek = new Client("Darek", "Szybki", listMoto1);
		Client Jarek = new Client("Jarek", "Dynamiczny", listMoto2);
		
		List<Client> listClient = new ArrayList<Client>();
		listClient.add(Darek);
		listClient.add(Jarek);
		
		Personnel rental = new Personnel("Jan", "Uczciwy", listClient);
				rental.printPersonnel();
				rental.printClientList();
				
				Darek.returnMotor(GSX_R);
				Darek.borrowMotor(R1);
				
				Jarek.borrowMotor(GSX_R);
				
				rental.printPersonnel();
				rental.printClientList();
				
				SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();

				session.save(R1);
				session.save(GSX_R);
				session.save(R6);
				
				
				session.getTransaction().commit();
	
	}

}