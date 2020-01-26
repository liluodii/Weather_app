package com.example.weather1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<ConsolidatedWeather> arrayList;
    private Context context;
    private View.OnClickListener listener;

    public Adapter(ArrayList<ConsolidatedWeather> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner){

        listener = itemClickListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String abrr = "https://www.metaweather.com/static/img/weather/png/64/"+ arrayList.get(position).getWeatherStateAbbr() +".png";
        String day = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = dateFormat.parse(arrayList.get(position).getApplicableDate());
            SimpleDateFormat format = new SimpleDateFormat("E");

            day = format.format(date);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Picasso.get().load(abrr).into(holder.weatherImage);
        holder.days.setText(day);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView weatherImage;
        TextView days;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            weatherImage = itemView.findViewById(R.id.image);
            days = itemView.findViewById(R.id.days);


            itemView.setTag(this);
            itemView.setOnClickListener(listener);

        }
    }

}
