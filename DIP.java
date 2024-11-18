public class MyDatabase {
    public int write(String inputString) {
        System.out.println("Writing to database: " + inputString);
        return 1; 
    }
}
public class EncodingModule {
    private MyDatabase myDatabase = new MyDatabase();

    public void encodeWithFiles() {
        System.out.println("Encoding with files...");
    }

    public void encodeBasedOnNetworkAndDatabase() {
        System.out.println("Encoding based on network");
        String data = "Network data to encode"; 
        int status = myDatabase.write(data);
        if (status == 1) {
            System.out.println("Data successfully written to database.");
        } else {
            System.out.println("Failed to write data to database.");
        }
    }
}
public class EncodingModuleClient {
    public static void main(String[] args) {
        EncodingModule encodingModule = new EncodingModule();

        System.out.println("Using EncodingModule to encode with files:");
        encodingModule.encodeWithFiles();

        System.out.println("\nUsing EncodingModule to encode based on network and database:");
        encodingModule.encodeBasedOnNetworkAndDatabase();
    }
}
