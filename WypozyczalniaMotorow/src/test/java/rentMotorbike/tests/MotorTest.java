package rentMotorbike.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rentMotorbike.EngineVolume;
import rentMotorbike.Maker;
import rentMotorbike.Motor;
import rentMotorbike.MotorName;
import rentMotorbike.MyException;

public class MotorTest {
	
	Motor motor = new Motor ("model", "producent", "moc");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		assertTrue(motor.name.equals("model"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMotorStringString() {
		assertTrue(motor.name.equals("model"));
		assertTrue(motor.maker.equals("producent"));
		
	}

	@Test
	public void testMotorMotorNameEngineVolumeMaker() {
		assertSame("", MotorName.R1, Maker.YAMAHA);
	}
	
	@Test
	public void testGetName() {
		assertTrue(motor.getName().equals("model"));
	}

	@Test
	public void testSetName() {
		motor.setName("nowyModel");
		assertTrue(motor.name.equals("nowyModel"));
		assertEquals(MotorName.R1, MotorName.R6);
	}

	@Test
	public void testGetEngineVolume() {
		assertTrue(motor.getEngineVolume().equals("moc"));
		assertNull("power is not null", EngineVolume.P_1000);
	}
	
	@Test
	public void testGetMaker() {
		assertTrue(motor.getMaker().equals("producent"));
		assertSame("", Maker.DUCATI, Maker.HONDA);
	}

	@Test
	public void testSetMaker() {
		assertTrue(true);
		
	}
	@Test(expected=MyException.class, timeout=100)
	public void testException() throws MyException
	{
		new Motor(MotorName.GSX_R, EngineVolume.P_600, null).setPower(600);
	}

}
