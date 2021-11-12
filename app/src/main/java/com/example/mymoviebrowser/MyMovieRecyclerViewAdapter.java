package com.example.mymoviebrowser;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymoviebrowser.databinding.FragmentItemBinding;

import java.util.List;

/**

 * TODO: Replace the implementation with code for your data type.
 */
public class MyMovieRecyclerViewAdapter extends RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder> {

    private final List<Movie> mValues;
    private final MovieFragment.MovieListener mListener;
    int selectedIndex = -1;

    public MyMovieRecyclerViewAdapter(List<Movie> mValues, MovieFragment.MovieListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(position + 1 + "");
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.movieSelected(holder.mItem);
                    notifyItemChanged(selectedIndex);
                    selectedIndex = holder.getLayoutPosition();
                    notifyItemChanged(selectedIndex);

                }
            }
        });
        holder.itemView.setBackgroundColor(selectedIndex == position ? Color.GREEN :
                Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Movie mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}