import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/**
 * Takes the input of 2 files line by line logically AND's each line and concatenates the name on the front
 * author: K Iverson 
 * date: May 5 2025
 * */
class Matching {
    public static void main(String[] args) {
    	String file1Path = "HS_SS_AHW_nuc_run5.sites";
        String file2Path = "HS_SS_BHW_nuc_run5.sites";
        String genName = "SNPs_all_nuc_beagle.txt";
        String outputPath = "Zero.txt";

        String line1, line2, line3;
        Set<String> zeroGenes = new HashSet<>();
        Set<String> oneGenes = new HashSet<>();
        Set<String> wholeSet = new HashSet<>();

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2Path));
            BufferedReader reader3 = new BufferedReader(new FileReader(genName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
        		
        ) {
        	reader3.readLine();
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null && (line3 = reader3.readLine()) != null) {

                line1 = line1.trim();
                line2 = line2.trim();
                line3 = line3.trim();
                
          //checks to see if boths are 1
                String result = (line1.equals("1") && line2.equals("1")) ? "1" : "0";
                if (result.equals("0")) {
                    zeroGenes.add(line3); // Add gene name to set
                }
            }

            // Optionally write the zero-result genes to file
            for (String gene : zeroGenes) {
                writer.write(gene);
                writer.newLine();
            
            }
            
            System.out.println("Comparison complete. Output saved to " + outputPath);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}