package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.Stat;
import com.bumptech.glide.Glide;

import java.util.List;


public class CommandersAdapter extends RecyclerView.Adapter<CommandersAdapter.ViewHolder> {

    private List<Stat> commanders;
    private Context context;

    public CommandersAdapter(List<Stat> commanders, Context context) {
        this.commanders = commanders;
        this.context = context;
    }


    @Override
    public CommandersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.commander_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        /*String commanderName = commanders.get(position).getCommanderKey();
        String commanderBattles = Long.toString(commanders.get(position).getVictories() +
                +commanders.get(position).getDefeats());
        String commanderMaxPointsCent = Long.toString(commanders.get(position).getMaxPointsCents() / 100);
        String commanderFreeXpCents = Long.toString(commanders.get(position).getFreeXPCents() / 100);
        String commanderUnitXpCents = Long.toString(commanders.get(position).getUnitXPCents() / 100);
        String commanderSilverCents = Long.toString(commanders.get(position).getSilverCents() / 100);

        holder.commanderName.setText("Имя: " + commanderName);
        holder.commanderBattles.setText("Битвы: " + commanderBattles);
        holder.commanderMaxPointsCent.setText("Рекорд по очкам: " + commanderMaxPointsCent);
        holder.commanderFreeXpCents.setText("Свободный опыт: " + commanderFreeXpCents);
        holder.commanderUnitXpCents.setText("Опыт отряда: " + commanderUnitXpCents);
        holder.commanderSilverCents.setText("Серебро: " + commanderSilverCents);*/


        String commanderName = commanders.get(position).getCommanderKey();
        Glide.with(context).load(CommanderSpecific.getImage(commanderName,context)).into(holder.commanderView);

        holder.commanderName.setText(CommanderSpecific.getCorrectName(commanderName));

        holder.commanderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommanderDetailActivity.class);
                intent.putExtra("commander", commanders.get(position));
                context.startActivity(intent);
            }
        });

/*        Contact contact = mContacts.get(position);
        holder.rootView.setTag(contact);
        holder.tvName.setText(contact.getName());

        Glide.with(context).load(contact.getThumbnailDrawable()).centerCrop().into(holder.ivProfile);*/
    }

    @Override
    public int getItemCount() {
        return commanders.size();
    }

    public int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }

    public String getCorrectName(String jsonName) {
        switch (jsonName) {
            case "gre_cynane":
                return "Кинана";
            case "gre_leonidas":
                return "Леонид";
            case "gre_miltiades":
                return "Мильтиад";
            case "gre_alexander":
                return "Александр Македонский";

            case "bar_arminius":
                return "Арминий";
            case "bar_ambiorix":
                return "Амбиорикс";
            case "bar_vercingetorix":
                return "Верцингеториг";

            case "car_hannibal":
                return "Ганнибал";
            case "car_hasdrubal":
                return "Гаструбал";


            case "rom_germanicus":
                return "Германик";
            case "rom_scipio":
                return "Сципион Африканский";
            case "rom_caesar":
                return "Гай Юлий Цезарь";
            case "rom_sulla":
                return "Сулла";
        }
        return "Some Commander";
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        /*TextView commanderName;
        TextView commanderBattles;
        TextView commanderMaxPointsCent;
        TextView commanderFreeXpCents;
        TextView commanderUnitXpCents;
        TextView commanderSilverCents;*/

        final ImageView commanderView;
        final TextView commanderName;
        final View vPalette;

        ViewHolder(View view) {
            super(view);

            commanderView = (ImageView) itemView.findViewById(R.id.commander_view);
            commanderName = (TextView) itemView.findViewById(R.id.commander_name);
            vPalette = itemView.findViewById(R.id.vPalette);




            /*commanderName = (TextView) view.findViewById(R.id.commander_name);
            commanderBattles = (TextView) view.findViewById(R.id.commander_battles);
            commanderMaxPointsCent = (TextView) view.findViewById(R.id.commander_max_points_cent);
            commanderFreeXpCents = (TextView) view.findViewById(R.id.commander_free_xp_cents);
            commanderUnitXpCents = (TextView) view.findViewById(R.id.commander_unit_xp_cents);
            commanderSilverCents = (TextView) view.findViewById(R.id.commander_silver_cents);*/
        }




    }
}

