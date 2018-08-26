package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.Stat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class CommanderDetailActivity extends AppCompatActivity {

    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;
    Stat commander;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_detail);

        commander = (Stat) getIntent().getSerializableExtra("commander");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        String commanderName = commander.getCommanderKey();
        toolbarLayout.setTitle(CommanderSpecific.getCorrectName(commanderName));

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        description = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);

        String commanderBattles = Long.toString(commander.getVictories() + commander.getDefeats());


        title.setText("Battles: " + commanderBattles);
        description.setText("Commander Discription");


        Glide.with(this)
                .load(CommanderSpecific.getImagePoster(commanderName,this))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(backdrop);

        Glide.with(this)
                .load(CommanderSpecific.getImage(commanderName+"_backdrop",this))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(poster);
    }

}
