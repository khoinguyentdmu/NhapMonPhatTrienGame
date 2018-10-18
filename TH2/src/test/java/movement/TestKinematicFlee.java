package movement;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestKinematicFlee {
	@Test
	public void TestKinematicFlee() {
		Charater charater = new Charater();
		charater.setPosition(new Vector2D(2, 1));
		
		Charater target = new Charater();
		target.setPosition(new Vector2D(9, 1));
		
		KinematicFlee kinematicSeek = new KinematicFlee(charater, target, 3);
		KinematicOutput kinematicOutputFlee = kinematicSeek.generateKinematicOutput();
		
		charater.update(kinematicOutputFlee, 2);
		charater.applyNewOrientation();
			
		assertEquals(charater.getPosition().toString(), "Vector2D [x=-12.0, z=0.0]");
		// ...
	}
}
