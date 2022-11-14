package com.social.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.social.instagram.Fragment.EmailFragment;
import com.social.instagram.Fragment.PhoneFragment;
import com.social.instagram.databinding.ActivitySignup3Binding;


public class Signup_3Activity extends AppCompatActivity {

    ActivitySignup3Binding binding;
    LinearLayout Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignup3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        PhoneFragment fragment = new PhoneFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();


        binding.textEmail.setTextColor(getResources().getColor(R.color.grey));
        binding.view2.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.grey));

        binding.textPhone.setTextColor(getResources().getColor(R.color.black));
        binding.view1.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.black));


        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhoneFragment fragment = new PhoneFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();

                binding.textEmail.setTextColor(getResources().getColor(R.color.grey));
                binding.view2.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.grey));


                binding.textPhone.setTextColor(getResources().getColor(R.color.black));
                binding.view1.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.black));

            }
        });

        binding.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EmailFragment fragment = new EmailFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();

                binding.textPhone.setTextColor(getResources().getColor(R.color.grey));
                binding.view1.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.grey));


                binding.textEmail.setTextColor(getResources().getColor(R.color.black));
                binding.view2.setBackgroundColor(ContextCompat.getColor(Signup_3Activity.this,R.color.black));


            }
        });


        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Signup_3Activity.this, MainActivity.class));


            }
        });

    }
}