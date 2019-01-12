package com.assignment.arpit.assignmentsfinal;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrecycler;
    FirebaseDatabase mfirebase;
    DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("List");
        mrecycler= (RecyclerView) findViewById(R.id.recycler);

        mrecycler.setHasFixedSize(true);
        mrecycler.setLayoutManager(new LinearLayoutManager(this));
        mfirebase=FirebaseDatabase.getInstance();
        mref=mfirebase.getReference("User");
        mref.keepSynced(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<model,viewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<model, viewHolder>(model.class,R.layout.individual_row,viewHolder.class,mref) {
            @Override
            protected void populateViewHolder(viewHolder viewHolder, model model, int position) {
                viewHolder.setDetail(getApplicationContext(),model.getName(),model.getAge());

            }
        };
        mrecycler.setAdapter(firebaseRecyclerAdapter);


    }
}
