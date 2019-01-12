package com.assignment.arpit.assignmentsfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class viewHolder extends RecyclerView.ViewHolder {
    View mview;
    public viewHolder(View itemView) {
        super(itemView);
        mview=itemView;
    }
    public void setDetail(Context ctx,String Name,String Age)
    {
        TextView mtitle=(TextView)mview.findViewById(R.id.name);
        TextView mdescription=(TextView)mview.findViewById(R.id.age);
//        ImageView mimage=(ImageView)mview.findViewById(R.id.image);
        mtitle.setText(Name);
        mdescription.setText(Age);

//        Picasso.get().load(Image).into(mimage);

    }
}
