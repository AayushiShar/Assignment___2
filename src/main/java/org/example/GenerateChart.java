package org.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateChart {
    public static JFreeChart createChart(List<ExcelDataModel> data) {
        // Example: Create a bar chart with team names and the count of interviews
        CategoryDataset dataset = createDataset(data);
        JFreeChart chart = ChartFactory.createBarChart(
                "Interviews by Team",
                "Team",
                "Number of Interviews",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Customize chart properties as needed

        return chart;
    }

    private static CategoryDataset createDataset(List<ExcelDataModel> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Example: Count interviews by team
        Map<String, Long> teamInterviewCounts = data.stream()
                .collect(Collectors.groupingBy(ExcelDataModel::getTeam, Collectors.counting()));

        teamInterviewCounts.forEach((team, count) -> {
            dataset.addValue(count, "Interviews", team);
        });

        // Add other dataset entries as needed

        return dataset;
    }
    public static JFreeChart createPiChart(String title, DefaultPieDataset dataset)
    {
        JFreeChart chart=ChartFactory.createPieChart(title,//chart title
                dataset,true, true,  false );
        int width=640;
        int height=480;
        return chart;

    }
}