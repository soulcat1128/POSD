package builder.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ComputerTest {
    
    @Test
    public void testComputer() {
        Computer computer1 = new Computer.Builder()  // 使用完整的內部類名稱
            .cpu("Intel i7")
            .ram("16GB")
            .storage("1TB")
            .gpu("Nvidia RTX 2080")
            .build();
        
        Computer computer2 = new Computer.Builder()
            .cpu("Ryzen 7 5700X3D")
            .ram("16GB")
            .storage("1TB")
            .gpu("Nvidia RTX 3060TI DDR6X")
            .build();


        // 可以測試基本的正確性
        assertEquals("Computer{cpu='Intel i7', ram='16GB', storage='1TB', gpu='Nvidia RTX 2080'}", computer1.toString());
        assertEquals("Computer{cpu='Ryzen 7 5700X3D', ram='16GB', storage='1TB', gpu='Nvidia RTX 3060TI DDR6X'}", computer2.toString());
    }
}
