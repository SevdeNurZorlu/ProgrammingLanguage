package com.svdnr.programminglanguage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static com.svdnr.programminglanguage.R.layout.item_language_card;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String data1[],data2[],data3[];

    int[] images;

    Context context;

    //adapterimiz 4 parametre alacak

    public MyAdapter(Context ct, String[] s1, String[] s2,String[] s3, int[] img){

        context=ct;
        data1=s1;
        data2=s2;
        data3=s3;
        images=img;
    }

    @NonNull
    @Override
    //onCreateViewHolder() : Bu method adaptör oluşturulduğunda oluşturduğumuz ViewHolder'ın başlatılması için çağrılır.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(item_language_card,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    //onBindViewHolder() : onCreateViewHolder’dan dönen verileri bağlama işlemini gerçekleştirildiği metotdur.
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.imageView.setImageResource(images[position]);
         holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("images",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    //getItemCount() : Listemizin eleman sayısını döndüren metottur.
    public int getItemCount() {

        return images.length;
    }


    //MyViewHolder(): Her bir satırımızın içinde bulunan bileşenleri tanımlama işleminin yapıldığı metottur
    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView text1, text2;
        ImageView imageView;
        ConstraintLayout mainLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            text1=itemView.findViewById(R.id.myText1);
            text2=itemView.findViewById(R.id.myText2);
            imageView=itemView.findViewById(R.id.myImageView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }


    }
}
