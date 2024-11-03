import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {
    private Plot plot1, plot2, plot3;

    @BeforeEach
    public void setUp() {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(3, 4, 4, 3);
        plot3 = new Plot(0, 0, 10, 10);
    }

    @AfterEach
    public void tearDown() {
        plot1 = plot2 = plot3 = null;
    }

    @Test
    public void testConstructor() {
        Plot testPlot = new Plot(1, 1, 5, 5);
        assertEquals(1, testPlot.getX());
        assertEquals(1, testPlot.getY());
        assertEquals(5, testPlot.getWidth());
        assertEquals(5, testPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
        assertTrue(plot1.overlaps(plot3));
    }

    @Test
    public void testEncompasses() {
        assertTrue(plot3.encompasses(plot1));
        assertFalse(plot1.encompasses(plot3));
    }

    @Test
    public void testToString() {
        assertEquals("3,4,4,3", plot2.toString());
    }
}
