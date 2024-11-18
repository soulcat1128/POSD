package builder.pattern;

public class Director {
    private Computer.Builder builder;
    
    Director(Computer.Builder builder)
    {
        this.builder = builder;
    }

    public Computer buildGamingComputer()
    {
        return builder.cpu("R7")
            .gpu("RTX 3060TI")
            .storage("1TB")
            .ram("16GB")
            .build();
    }

    public Computer buildOfficeComputer()
    {
        return builder.cpu("i5")
            .gpu("GTX 1660")
            .storage("512GB")
            .ram("8GB")
            .build();
    }
}
