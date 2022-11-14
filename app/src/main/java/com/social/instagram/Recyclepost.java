package com.social.instagram;

import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

public class Recyclepost extends RecyclerView.Adapter<Recyclepost.viewholder> {

    MainActivity mainActivity;
    int[] images;
    String[] name;
    int count = 0;

    public Recyclepost(MainActivity mainActivity, int[] images, String[] name) {
        this.mainActivity = mainActivity;
        this.images = images;
        this.name = name;
    }

    @NonNull
    @Override
    public Recyclepost.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclepost.viewholder holder, int position) {

        holder.username.setText(name[position]);
        Glide.with(mainActivity).load(images[position]).into(holder.profile);
        Glide.with(mainActivity).load(images[position]).into(holder.post);

        holder.post.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onSingleClick(View v) {

//                Toast.makeText(mainActivity, "Incomplete Task", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClick(View v) {

                vibrate();
                likecount(holder);

                holder.gifImageView.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        holder.gifImageView.setVisibility(View.GONE);

                    }
                },800);

            }
        });

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                likecount(holder);

            }
        });




    }

    private void likecount(@NonNull viewholder holder) {
        if(count == 1){
            holder.favorite.setImageResource(R.drawable.ic_red_favorite);
            count = 0;
        }
        else{
            holder.favorite.setImageResource(R.drawable.ic_outline_favorite);
            count = 1;
        }
    }

    private void vibrate() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            final Vibrator vibrator = (Vibrator)mainActivity.getSystemService(mainActivity.VIBRATOR_SERVICE);
            final VibrationEffect vibrationEffect1;

            // this effect creates the vibration of default amplitude for 1000ms(1 sec)
            vibrationEffect1 = VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);

            // it is safe to cancel other vibrations currently taking place
            vibrator.cancel();
            vibrator.vibrate(vibrationEffect1);
        }
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class viewholder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        ImageView post,favorite;
        TextView username;
        GifImageView gifImageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_img);
            post = itemView.findViewById(R.id.post);
            favorite = itemView.findViewById(R.id.favorite);
            gifImageView = itemView.findViewById(R.id.gif_image);
            username = itemView.findViewById(R.id.username);

        }
    }
}
