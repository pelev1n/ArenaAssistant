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

        TextView comBattles = (TextView) findViewById(R.id.commander_battles);
        TextView comVictories = (TextView) findViewById(R.id.commander_victories);
        TextView comMaxPointCents = (TextView) findViewById(R.id.commander_max_points_cents);
        TextView comFreeXpCents = (TextView) findViewById(R.id.commander_free_xp_cents);
        TextView comUnitXpCents = (TextView) findViewById(R.id.commander_battles_unit_xp_cents);
        TextView comSilverCents = (TextView) findViewById(R.id.commander_silver_cents);
        TextView comTimeInBattles = (TextView) findViewById(R.id.commander_time_in_battles);

        String commanderBattles = Long.toString(commander.getVictories() + commander.getDefeats());
        String commanderVictories = Long.toString((commander.getVictories() * 100) /
                (commander.getVictories() + commander.getDefeats()));
        String commanderMaxPointCents = Long.toString(commander.getMaxPointsCents()/100);
        String commanderFreeXpCents = Long.toString(commander.getFreeXPCents()/100);
        String commanderUnitXpCents = Long.toString(commander.getUnitXPCents()/100);
        String commanderSilverCents = Long.toString(commander.getSilverCents()/100);
        String commanderTimeInBattles = Long.toString(commander.getTimeInBattle()/100);


        title.setText("Battles: " + commanderBattles);
        description.setText("Commander Discription");


        /*Glide.with(this)
                .load(CommanderSpecific.getImagePoster(commanderName, this))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(backdrop);*/
        Glide.with(this)
                .load(CommanderSpecific.getImage(commanderName + "_backdrop", this))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(backdrop);

        Glide.with(this)
                .load(CommanderSpecific.getImage(commanderName + "_backdrop", this))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(poster);

        comBattles.setText("Battles: " + commanderBattles);
        comVictories.setText("Winrate: " + commanderVictories + "%");
        comMaxPointCents.setText("Max Point cents: " + commanderMaxPointCents);
        comFreeXpCents.setText("Free xp: " + commanderFreeXpCents);
        comUnitXpCents.setText("Unit xp cents: " + commanderUnitXpCents);
        comSilverCents.setText("Silver: " + commanderSilverCents);
        comTimeInBattles.setText("Time in battles: " + commanderTimeInBattles);
    }

}
