package com.social.instagram;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleStory extends RecyclerView.Adapter<RecycleStory.viewholder> {

    int[] images;
    MainActivity mainActivity;

    public RecycleStory(MainActivity mainActivity , int[] images) {

        this.mainActivity = mainActivity;
        this.images = images;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_story,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Glide.with(mainActivity).load(images[position]).into(holder.imageView);



        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class viewholder extends RecyclerView.ViewHolder {

        CircleImageView imageView;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_story_img);

        }
    }
}
