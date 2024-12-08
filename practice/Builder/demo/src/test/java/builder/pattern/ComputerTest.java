package builder.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


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

    @Test
    public void testComputerFromFile() {
        try {
            // 指定文件路徑
            File file = new File("C:/Users/GKY/Desktop/POSD/POSD/practice/Builder/demo/src/main/resources/test.txt");
            Scanner scanner = new Scanner(file);

            // 第一台電腦的測試
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // String[] parts = line.split(",");

                // Computer computer1 = new Computer.Builder()
                //     .cpu(parts[0].trim())
                //     .ram(parts[1].trim())
                //     .storage(parts[2].trim())
                //     .gpu(parts[3].trim())
                //     .build();

                // assertEquals("Computer{cpu='Intel i7', ram='16GB', storage='1TB', gpu='Nvidia RTX 2080'}", computer1.toString());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }


    @Test
    public void testScanner()
    {
        // input may be : Circle 3.0, color=RED  or Circle 3.0, text=This is a circle   or  Circle 3.0, color=RED, text=This is a circle
        String input = "Circle 3.0, color=RED";
        Scanner s = new Scanner(input).useDelimiter("\\s*,\\s*");
        String shape = s.next();
        double radius = s.nextDouble();
        String color = "white";
        
        s.close();
    }
}
