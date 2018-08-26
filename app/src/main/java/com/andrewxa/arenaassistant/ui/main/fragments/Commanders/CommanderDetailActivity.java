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

public class CommanderDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "movie";

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

        title.setText("Commander Tittle");
        description.setText("Commander Discription");


        Glide.with(this).load(CommanderSpecific.getImage(commanderName,this)).into(backdrop);
        Glide.with(this).load(R.drawable.rom_germanicus).into(poster);
        /*dataManager.getmPicaso().with(this)
                .load("http://image.tmdb.org/t/p/w500" + mMovie.getPoster())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(poster);

        dataManager.getmPicaso().with(this)
                .load("http://image.tmdb.org/t/p/w500" + mMovie.getBackdrop())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(backdrop);*/
    }

}
