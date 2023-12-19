package org.example;// Main.java
import org.jfree.chart.JFreeChart;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create table in the database
            DatabaseManager.createTable();

            // Step 2: Read Excel data
            List<ExcelDataModel> data = ReadExcel.readExcel("C:\\Users\\sharma.aayushi\\Downloads\\Accolite Interview Data - Q4 2023 - Grad Program November 2023.xlsx");

            // Step 3: Insert data into the database
            DatabaseManager.insertData(data);
            DatabaseManager.teamWithMaxInterviews();
            DatabaseManager.teamWithMinInterviews();
            DatabaseManager.top3Skills();
            DatabaseManager.top3Panels();
            DatabaseManager.skillsInPeakTime();

            // Step 4: Generate charts
            JFreeChart chart = GenerateChart.createChart(data);

            // Step 5: Generate PDF and embed charts
            PdfGenerator.generatePdf(data, "C:\\Users\\sharma.aayushi\\Downloads\\chart\\ExcelFileReader\\src\\main\\java\\org\\example\\output");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}