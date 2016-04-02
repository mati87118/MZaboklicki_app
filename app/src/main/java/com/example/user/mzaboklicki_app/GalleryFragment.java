package com.example.user.mzaboklicki_app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    private ImageView selectedImage;
    private Integer[] mImageIds = {
            R.drawable.husar,
            R.drawable.mat2,
            R.drawable.mat3,
            R.drawable.mat4,
            R.drawable.mat5,
            R.drawable.mat6,
            R.drawable.mat7
    };
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Gallery gallery = (Gallery) getView().findViewById(R.id.gallery1);
        selectedImage=(ImageView)getView().findViewById(R.id.imageView1);
        gallery.setSpacing(1);
        gallery.setAdapter(new GalleryImageAdapter(getContext()));

        // clicklistener for Gallery
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(mImageIds[position]);
            }
        });
    }

    public class GalleryImageAdapter extends BaseAdapter
    {
        private Context mContext;

        private Integer[] mImageIds = {
                R.drawable.husar,
                R.drawable.mat2,
                R.drawable.mat3,
                R.drawable.mat4,
                R.drawable.mat5,
                R.drawable.mat6,
                R.drawable.mat7
        };

        public GalleryImageAdapter(Context context)
        {
            mContext = context;
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }


        // Override this method according to your need
        public View getView(int index, View view, ViewGroup viewGroup)
        {
            // TODO Auto-generated method stub
            ImageView i = new ImageView(mContext);

            i.setImageResource(mImageIds[index]);
            i.setLayoutParams(new Gallery.LayoutParams(200, 200));

            i.setScaleType(ImageView.ScaleType.FIT_XY);

            return i;
        }
    }
}
