package builder.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectorTest {
    @Test
    public void testDirector() {
        Computer.Builder builder = new Computer.Builder();
        Director director = new Director(builder);

        Computer computer1 = director.buildGamingComputer();
        Computer computer2 = director.buildOfficeComputer();

        assertEquals("Computer{cpu='R7', ram='16GB', storage='1TB', gpu='RTX 3060TI'}", computer1.toString());
        assertEquals("Computer{cpu='i5', ram='8GB', storage='512GB', gpu='GTX 1660'}", computer2.toString());
    }
}
