package com.example.weather1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class first_fragment extends Fragment {
    ImageView imageView;
    Adapter adapter;
    public TextView min,max,the,humidity,wind;


    public ArrayList <ConsolidatedWeather> arrayList;
    public ArrayList<Data> DataArraylist;

    int i;

    String url ="https://www.metaweather.com/static/img/weather/png/64/sn.png";

    public ArrayList<Data>builtData(ArrayList<ConsolidatedWeather> consolidatedWeather){

        DataArraylist =new ArrayList<>();
        for(i=0;i<consolidatedWeather.size();i++)
        {
            Data mydata=new Data();
            mydata.setWeatherStateName(consolidatedWeather.get(i).getWeatherStateName());
            mydata.setWeatherstateAbbr(consolidatedWeather.get(i).getWeatherStateAbbr());
            mydata.setApplicableDate(consolidatedWeather.get(i).getApplicableDate());
            mydata.setMaxtemp(consolidatedWeather.get(i).getMaxTemp());
            mydata.setMintemp(consolidatedWeather.get(i).getMinTemp());
            mydata.setTheTemp(consolidatedWeather.get(i).getTheTemp());
            mydata.setHumidity(consolidatedWeather.get(i).getHumidity());
            mydata.setPredictability(consolidatedWeather.get(i).getPredictability());
            if(i!=0)
            {
                DataArraylist.add(mydata);
            }
            else{
               // todayweather=mydata;
            }


        }
        return DataArraylist;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        min=getActivity().findViewById(R.id.txtmin);
        max=getActivity().findViewById(R.id.txtmax);
        humidity=getActivity().findViewById(R.id.txthumidity);
        wind=getActivity().findViewById(R.id.txtwind);
        the=getActivity().findViewById(R.id.txtthe);
        imageView = getActivity().findViewById(R.id.imageView);

        Picasso.get().load(url).into(imageView);
        DataService dataService = RetroFitClient.getRetrofitInstance().create(DataService.class);
        Call<ArrayList<ConsolidatedWeather>> call = dataService.getWeathers();
        call.enqueue(new Callback<ArrayList<ConsolidatedWeather>>() {
            @Override

            public void onResponse(Call<ArrayList<ConsolidatedWeather>> call, Response<ArrayList<ConsolidatedWeather>> response) {
                ArrayList<ConsolidatedWeather> consolidatedWeather = response.body();
                try {
                    arrayList = new ArrayList<>(consolidatedWeather);
                    generateRecyclerView(arrayList);
                } catch (NullPointerException exception) {
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ConsolidatedWeather>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Something Went Wrong!" + t.getMessage(), Toast.LENGTH_LONG).show();
            }


        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_fragment, container, false);



    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);



    }



public void generateRecyclerView(ArrayList<ConsolidatedWeather> arrayList)
{
    adapter=new Adapter(arrayList,getActivity().getApplicationContext());
    LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    RecyclerView recyclerView = getActivity().findViewById(R.id.rv_day);

    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(adapter);
}

}



