package com.example.corona;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DetailedActivity extends AppCompatActivity {

    private int positionCountry;
    SimpleArcLoader simpleArcLoaderDetailed;
    ScrollView scrollViewDetailed;
    PieChart pieChartDetailed;
    TextView tvCountry_detailed,tvCases_detailed,tvActive_detailed,tvTotalDeaths_detailed,tvRecovered_detailed,tvCritical_detailed,tvTodayCases_detailed,tvTodayDeaths_detailed,tvTodayRecovered_detailed,tvTests_detailed,tvPopulation_detailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        simpleArcLoaderDetailed = findViewById(R.id.loader_detailed);
        scrollViewDetailed = findViewById(R.id.scrollStats_detailed);
        pieChartDetailed = findViewById(R.id.piechart_detailed);



        tvCountry_detailed = findViewById(R.id.tvCountry_detailed);
        tvCases_detailed = findViewById(R.id.tvCases_detailed);
        tvActive_detailed = findViewById(R.id.tvActive_detailed);
        tvTotalDeaths_detailed = findViewById(R.id.tvTotalDeaths_detailed);
        tvRecovered_detailed = findViewById(R.id.tvRecovered_detailed);
        tvCritical_detailed = findViewById(R.id.tvCritical_detailed);
        tvTodayCases_detailed = findViewById(R.id.tvTodayCases_detailed);
        tvTodayDeaths_detailed = findViewById(R.id.tvTodayDeaths_detailed);
        tvTodayRecovered_detailed = findViewById(R.id.tvTodayRecovered_detailed);
        tvTests_detailed = findViewById(R.id.tvTests_detailed);
        tvPopulation_detailed = findViewById(R.id.tvPopulation_detailed);

        tvCountry_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getCountry());
        tvCases_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getCases());
        tvActive_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getActive());
        tvTotalDeaths_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getDeaths());
        tvRecovered_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getRecovered());
        tvCritical_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getCritical());
        tvTodayCases_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getTodayCases());
        tvTodayDeaths_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getTodayDeaths());
        tvTodayRecovered_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getTodayRecovered());
        tvTests_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getTests());
        tvPopulation_detailed.setText(Affected_Countries.countryModelList.get(positionCountry).getPopulation());

        pieChartDetailed.addPieSlice(new PieModel("Cases",Integer.parseInt(Affected_Countries.countryModelList.get(positionCountry).getCases()), Color.parseColor("#FFA726")));
        pieChartDetailed.addPieSlice(new PieModel("Recovered",Integer.parseInt(Affected_Countries.countryModelList.get(positionCountry).getRecovered()),Color.parseColor("#66BB6A")));
        pieChartDetailed.addPieSlice(new PieModel("Deaths",Integer.parseInt(Affected_Countries.countryModelList.get(positionCountry).getDeaths()),Color.parseColor("#EF5350")));
        pieChartDetailed.addPieSlice(new PieModel("Active",Integer.parseInt(Affected_Countries.countryModelList.get(positionCountry).getActive()),Color.parseColor("#29B6F6")));
        pieChartDetailed.startAnimation();

        simpleArcLoaderDetailed.stop();
        simpleArcLoaderDetailed.setVisibility(View.GONE);
        scrollViewDetailed.setVisibility(View.VISIBLE);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
